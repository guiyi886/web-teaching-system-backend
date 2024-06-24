package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.domain.dto.JiChaoTestDTO;
import teaching.system.backend.domain.po.User;
import teaching.system.backend.domain.po.UserNotice;
import teaching.system.backend.domain.po.Wenxiang;
import teaching.system.backend.result.Result;
import teaching.system.backend.service.UserNoticeService;
import teaching.system.backend.service.UserService;
import teaching.system.backend.service.WenxiangService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/06/23/19:45
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class WenxinagController {
    @Resource
    private WenxiangService wenxiangService;
    @Resource
    private UserService userService;
    @Resource
    private UserNoticeService userNoticeService;

    @GetMapping("getPendingExperiments")
    public Result getPendingExperiments(@RequestParam String account) {
        log.info("获取未完成实验..");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        queryWrapper.eq("studentAccount", account);
        List<Wenxiang> list = wenxiangService.list();
        return Result.success(list);
    }

    @GetMapping("getSubmittedExperiments")
    public Result getSubmittedExperiments(@RequestParam String account) {
        log.info("获取完成的实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        List<Wenxiang> list = wenxiangService.list();
        return Result.success(list);
    }

    @GetMapping("getAllExperiments")
    public Result getAllExperiments() {
        log.info("获取未完成的实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        List<Wenxiang> list = wenxiangService.list();
        return Result.success(list);
    }

    @PostMapping("submitExperiment")
    public Result submitExperiment() {
        log.info("提交实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        List<Wenxiang> list = wenxiangService.list();
        return Result.success(list);
    }

    @PostMapping("publishExperiment")
    public Result publishExperiment() {
        log.info("发布实验");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        List<Wenxiang> list = wenxiangService.list();
        return Result.success("ok");
    }

    @PostMapping("publish_test_paper")
    public Result publishTestPaper(@RequestBody JiChaoTestDTO jiChaoTestDTO) {
        log.info("发布试卷..");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", "学生");
        List<User> userList = userService.list(queryWrapper);
        String testPaper = jiChaoTestDTO.getTestPaper();
        String testName = jiChaoTestDTO.getTestName();
        userList.forEach(user -> {
            Wenxiang wenxiang = new Wenxiang();
            wenxiang.setUsername(user.getUsername());
            wenxiang.setExperimentContent(testPaper);
            wenxiang.setExperimentTitle(testName);
            wenxiang.setStudentAccount(user.getAccount());
            wenxiangService.save(wenxiang);
            UserNotice userNotice = new UserNotice();
            userNotice.setDescription("试卷更新..");
            userNotice.setStudent(user.getUsername());
            userNotice.setStatus(1);
            userNoticeService.save(userNotice);
        });
        return Result.success("ok");
    }

    @GetMapping("get_published_test_papers")
    public Result getPublishedTestPapers() {
        log.info("获取发布试卷..");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", "学生");
        List<Wenxiang> list = wenxiangService.list(queryWrapper);
        return Result.success(list);
    }

}
