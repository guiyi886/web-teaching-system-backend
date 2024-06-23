package teaching.system.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import teaching.system.backend.domain.po.UserNotice;
import teaching.system.backend.mapper.UserNoticeMapper;
import teaching.system.backend.service.UserNoticeService;

/**
* @author ylw16
* @description 针对表【user_notice(用户关联通知)】的数据库操作Service实现
* @createDate 2024-06-14 09:45:20
*/
@Service
public class UserNoticeServiceImpl extends ServiceImpl<UserNoticeMapper, UserNotice>
    implements UserNoticeService{

}




