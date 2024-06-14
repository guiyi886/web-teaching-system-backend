package teaching.system.backend.service;

import org.springframework.stereotype.Service;
import teaching.system.backend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ylw16
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-06-14 08:49:10
*/
public interface UserService extends IService<User> {

}
