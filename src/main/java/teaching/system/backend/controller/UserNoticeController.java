package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.model.domain.PageResult;
import teaching.system.backend.model.domain.Result;
import teaching.system.backend.model.domain.UserNotice;
import teaching.system.backend.model.domain.UserTest;
import teaching.system.backend.model.dto.NoticeDTO;
import teaching.system.backend.service.UserNoticeService;
import teaching.system.backend.service.UserTestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/06/14/9:47
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/notice")
public class UserNoticeController {
    @Resource
    private UserNoticeService userNoticeService;
    @PostMapping
    public Result queryNotice(@RequestBody NoticeDTO noticeDTO){
        log.info("查询通知");
        QueryWrapper<UserNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student", noticeDTO.getUsername())
                .eq("status",noticeDTO.getStatus());
        List<UserNotice> userNoticeList = userNoticeService.list(queryWrapper);
        return Result.success(userNoticeList);
    }
}
