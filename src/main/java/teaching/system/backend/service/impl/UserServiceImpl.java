package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import teaching.system.backend.domain.dto.LoginDTO;
import teaching.system.backend.domain.po.User;
import teaching.system.backend.domain.vo.LoginVO;
import teaching.system.backend.mapper.UserMapper;
import teaching.system.backend.service.UserService;
import teaching.system.backend.util.HashUtil;


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
}




