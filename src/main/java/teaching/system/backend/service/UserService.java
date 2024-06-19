package teaching.system.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import teaching.system.backend.domain.dto.LoginDTO;
import teaching.system.backend.domain.po.User;

public interface UserService extends IService<User> {

    Object login(LoginDTO loginDTO);
}
