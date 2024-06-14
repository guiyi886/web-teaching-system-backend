package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import teaching.system.backend.model.domain.User;
import teaching.system.backend.service.UserService;
import teaching.system.backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ylw16
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-06-14 08:49:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




