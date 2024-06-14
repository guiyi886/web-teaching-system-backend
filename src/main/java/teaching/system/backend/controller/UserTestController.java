package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.model.domain.PageResult;
import teaching.system.backend.model.domain.Result;
import teaching.system.backend.model.domain.UserTest;
import teaching.system.backend.service.UserTestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/06/14/9:48
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class UserTestController {
    @Resource
    private UserTestService userTestService;
    @GetMapping("/page")
    public Result page(){
        log.info("首页题目分页");
        IPage<UserTest> page = new Page<>(1, 10);
        IPage<UserTest> userPage = userTestService.page(page); // 调用 page 方法
        List<UserTest> userList = userPage.getRecords();
        long total = userPage.getTotal();
        return Result.success(new PageResult(total,userList));
    }
    @GetMapping("/page/{query}")
    public Result page(@PathVariable String query){
        log.info("首页题目分页");
        IPage<UserTest> page = new Page<>(1, 10);
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("testName", query);
        IPage<UserTest> userPage = userTestService.page(page,queryWrapper); // 调用 page 方法
        List<UserTest> userList = userPage.getRecords();
        long total = userPage.getTotal();
        return Result.success(new PageResult(total,userList));
    }
}
