package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.domain.dto.JiChaoTestDTO;
import teaching.system.backend.domain.dto.WenxiangDTO;
import teaching.system.backend.domain.po.User;
import teaching.system.backend.domain.po.UserNotice;
import teaching.system.backend.domain.po.UserTest;
import teaching.system.backend.domain.po.Wenxiang;
import teaching.system.backend.result.Result;
import teaching.system.backend.service.UserNoticeService;
import teaching.system.backend.service.UserService;
import teaching.system.backend.service.UserTestService;
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
    @Resource
    private UserTestService userTestService;

    @GetMapping("getPendingExperiments")
    public Result getPendingExperiments(@RequestParam String account) {
        log.info("获取未完成实验..");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        queryWrapper.eq("student_account", account);
        List<Wenxiang> list = wenxiangService.list(queryWrapper);
        return Result.success(list);
    }

    @GetMapping("getSubmittedExperiments")
    public Result getSubmittedExperiments(@RequestParam String account) {
        log.info("获取完成的实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        List<Wenxiang> list = wenxiangService.list(queryWrapper);
        return Result.success(list);
    }

    @GetMapping("getAllExperiments")
    public Result getAllExperiments(@RequestParam String account) {
        log.info("获取未完成的实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1).or().eq("status", 0).eq("student_account", account);
        List<Wenxiang> list = wenxiangService.list(queryWrapper);
        return Result.success(list);
    }

    @GetMapping("getExperimentRecords")
    public Result getExperimentRecords() {
        log.info("获取实验记录..");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 2).or().eq("status", 1);
        List<Wenxiang> list = wenxiangService.list(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("submitExperiment")
    public Result submitExperiment(@RequestBody WenxiangDTO wenxiangDTO) {
        log.info("提交实验列表");
        QueryWrapper<Wenxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_account", wenxiangDTO.getStudentAccount());
        queryWrapper.eq("experiment_title", wenxiangDTO.getExperimentTitle());
        Wenxiang one = wenxiangService.getOne(queryWrapper);
        one.setCode(wenxiangDTO.getCode());
        one.setStatus("1");
        wenxiangService.updateById(one);
        return Result.success("OK");
    }

    @PostMapping("publishExperiment")
    public Result publishExperiment(@RequestBody WenxiangDTO wenxiangDTO) {
        log.info("发布实验");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", "学生");
        List<User> userList = userService.list(queryWrapper);
        String experimentTitle = wenxiangDTO.getExperimentTitle();
        String experimentContent = wenxiangDTO.getExperimentContent();
        userList.forEach(user -> {
            Wenxiang wenxiang = new Wenxiang();
            wenxiang.setUsername(user.getUsername());
            wenxiang.setExperimentContent(experimentContent);
            wenxiang.setExperimentTitle(experimentTitle);
            wenxiang.setStudentAccount(user.getAccount());
            wenxiang.setStatus("0");
            wenxiangService.save(wenxiang);
            UserNotice userNotice = new UserNotice();
            userNotice.setDescription("题目更新..");
            userNotice.setStudent(user.getUsername());
            userNotice.setStatus(2);
            userNoticeService.save(userNotice);
        });
        UserTest userTest = new UserTest();
        userTest.setStatus(1);
        userTest.setDescription(wenxiangDTO.getExperimentTitle());
        userTest.setTestName(wenxiangDTO.getExperimentTitle());
        userTest.setDetail(wenxiangDTO.getExperimentContent());
        userTestService.save(userTest);
        return Result.success("ok");
    }

    @PostMapping("correctionAndUpdate")
    public Result correctionAndUpdate(@RequestBody WenxiangDTO wenxiangDTO) {
        log.info("更新status");
        QueryWrapper<Wenxiang> wenxiangQueryWrapper = new QueryWrapper<>();
        wenxiangQueryWrapper.eq("student_account", wenxiangDTO.getStudentAccount());
        wenxiangQueryWrapper.eq("experiment_title", wenxiangDTO.getExperimentTitle());
        Wenxiang one = wenxiangService.getOne(wenxiangQueryWrapper);
        one.setStatus("2");
        wenxiangService.save(one);
        return Result.success("OK");
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
