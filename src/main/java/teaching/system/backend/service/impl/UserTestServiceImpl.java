package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import teaching.system.backend.domain.po.UserTest;
import teaching.system.backend.mapper.UserTestMapper;
import teaching.system.backend.service.UserTestService;

/**
* @author ylw16
* @description 针对表【user_test(用户关联习题)】的数据库操作Service实现
* @createDate 2024-06-14 09:45:25
*/
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest>
    implements UserTestService{

}




