package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import teaching.system.backend.domain.dto.LoginDTO;
import teaching.system.backend.domain.dto.UpdateInfoDTO;
import teaching.system.backend.domain.po.User;
import teaching.system.backend.domain.vo.LoginVO;
import teaching.system.backend.mapper.UserMapper;
import teaching.system.backend.service.UserService;
import teaching.system.backend.util.HashUtil;

import java.util.List;


@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Object login(LoginDTO loginDTO) {
        String account = loginDTO.getAccount();
        String hashedPassword = loginDTO.getHashedPassword();
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        String salt = user.getSalt();

        log.info("salt: {}", salt);
        log.info("loginDTO.getHashedPassword(): {}", hashedPassword);
        log.info("db_saltHashedPassword: {}", user.getSaltHashedPassword());
        log.info(HashUtil.sha256(hashedPassword + salt));
        /*if (true)
            return new Object();*/

        if (!user.getSaltHashedPassword().equals(HashUtil.sha256(loginDTO.getHashedPassword() + salt))) {
            throw new RuntimeException("密码错误");
        }

        LoginVO loginVO = new LoginVO();
        loginVO.setUsername(user.getUsername());
        loginVO.setAccount(user.getAccount());
        loginVO.setEmail(user.getEmail());
        loginVO.setPhone(user.getPhone());
        loginVO.setRole(user.getRole());
        loginVO.setId(user.getId());
        loginVO.setStatus(user.getStatus());

        return loginVO;
    }

    @Override
    public void updateInfo(UpdateInfoDTO updateInfoDTO) {
        String account = updateInfoDTO.getAccount();
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        log.info("接收到的邮箱{}", updateInfoDTO.getEmail());
        log.info("接收到的电话{}", updateInfoDTO.getPhone());
        user.setEmail(updateInfoDTO.getEmail());
        user.setPhone(updateInfoDTO.getPhone());

        // 保存更新后的用户信息到数据库
        boolean isUpdated = updateById(user);
        if (!isUpdated) {
            throw new RuntimeException("用户信息更新失败");
        }
    }

    @Override
    public String register(User user) {
        String account = user.getAccount();
        if (lambdaQuery().eq(User::getAccount, account).one() != null) {
            //throw new RuntimeException("用户已存在");
            return "用户已存在";
        }
        user.setRole("学生");
        user.setStatus(1);

        // 生成1到1000之间的随机整数
        int randomNumber = (int) (Math.random() * 1000) + 1;
        String salt = "random_salt_" + randomNumber;
        user.setSalt(salt);
        user.setSaltHashedPassword(HashUtil.sha256(user.getHashedPassword() + salt));

        boolean isInserted = save(user);
        if (!isInserted) {
            //throw new RuntimeException("用户注册失败");
            return "用户注册失败";
        }
        return "注册成功";
    }

    @Override
    public List<User> getStudents() {
        List<User> students = lambdaQuery().eq(User::getRole, "学生").list();
        return students;
    }

    @Override
    public void resetPassword(String account) {
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        user.setSaltHashedPassword(HashUtil.sha256(HashUtil.sha256("qwer1234") + user.getSalt()));
        boolean isUpdated = updateById(user);
        if (!isUpdated) {
            throw new RuntimeException("密码重置失败！");
        }
    }

    @Override
    public void disableStudent(String account) {
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        user.setStatus(0);
        boolean isUpdated = updateById(user);
        if (!isUpdated) {
            throw new RuntimeException("账号禁用失败！");
        }
    }

    @Override
    public void enableStudent(String account) {
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        user.setStatus(1);
        boolean isUpdated = updateById(user);
        if (!isUpdated) {
            throw new RuntimeException("账号启用失败！");
        }
    }

    @Override
    public void deleteStudent(String account) {
        User user = lambdaQuery().eq(User::getAccount, account).one();
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        boolean isDeleted = removeById(user.getId());
        if (!isDeleted) {
            throw new RuntimeException("用户删除失败");
        }
    }

    @Override
    public void forget(User user) {
        User userAll = lambdaQuery().eq(User::getAccount, user.getAccount()).one();
        if (userAll == null) {
            throw new RuntimeException("用户不存在");
        }
        if (userAll.getUsername().equals(user.getUsername()) && userAll.getIdentity().equals(user.getIdentity())) {
            resetPassword(user.getAccount());
        } else {
            throw new RuntimeException("用户信息错误");
        }
    }
}




