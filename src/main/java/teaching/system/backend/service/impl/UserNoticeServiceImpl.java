package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import teaching.system.backend.model.domain.UserNotice;
import teaching.system.backend.service.UserNoticeService;
import teaching.system.backend.mapper.UserNoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author ylw16
* @description 针对表【user_notice(用户关联通知)】的数据库操作Service实现
* @createDate 2024-06-14 09:45:20
*/
@Service
public class UserNoticeServiceImpl extends ServiceImpl<UserNoticeMapper, UserNotice>
    implements UserNoticeService{

}




