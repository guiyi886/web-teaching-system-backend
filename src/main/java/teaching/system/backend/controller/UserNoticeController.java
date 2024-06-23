package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.domain.dto.NoticeDTO;
import teaching.system.backend.domain.dto.NoticeUpdateDTO;
import teaching.system.backend.domain.po.UserNotice;
import teaching.system.backend.result.Result;
import teaching.system.backend.service.UserNoticeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
@CrossOrigin(origins = "*")
public class UserNoticeController {
    @Resource
    private UserNoticeService userNoticeService;

    @PostMapping
    public Result queryNotice(@RequestBody NoticeDTO noticeDTO) {
        log.info("查询通知");
        QueryWrapper<UserNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student", noticeDTO.getUsername())
                .eq("status", noticeDTO.getStatus())
                .orderByDesc("create_time");
        List<UserNotice> userNoticeList = userNoticeService.list(queryWrapper);
        List<String> list = userNoticeList.stream().map(UserNotice::getDescription).collect(Collectors.toList());
        return Result.success(list);
    }

    @PutMapping("/update/status")
    public Result read(@RequestBody NoticeUpdateDTO noticeUpdateDTO) {
        log.info("更新通知状态");
        if ("teacher".equals(noticeUpdateDTO.getRole())) {
            return Result.success("OK");
        }
        QueryWrapper<UserNotice> queryWrapper = new QueryWrapper<UserNotice>();
        queryWrapper.eq("description", noticeUpdateDTO.getDescription());
        queryWrapper.eq("student", noticeUpdateDTO.getUsername());
        UserNotice one = userNoticeService.getOne(queryWrapper);
        one.setStatus(0);
        userNoticeService.update(one, queryWrapper);
        return Result.success("OK");
    }
}
