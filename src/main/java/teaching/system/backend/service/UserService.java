package teaching.system.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import teaching.system.backend.domain.dto.LoginDTO;
import teaching.system.backend.domain.dto.UpdateInfoDTO;
import teaching.system.backend.domain.po.User;

import java.util.List;

public interface UserService extends IService<User> {

    Object login(LoginDTO loginDTO);

    void updateInfo(UpdateInfoDTO updateInfoDTO);

    String register(User user);

    List<User> getStudents();

    void resetPassword(String account);

    void disableStudent(String account);

    void enableStudent(String account);

    void deleteStudent(String account);
}
