package teaching.system.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.domain.dto.TestUpdateDTO;
import teaching.system.backend.domain.po.UserTest;
import teaching.system.backend.result.Result;
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
@CrossOrigin(origins = "*")
public class UserTestController {
    @Resource
    private UserTestService userTestService;

    @GetMapping("/all")
    public Result getAll() {
        log.info("拿到全部题目");
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<UserTest>();
        queryWrapper.orderByDesc("create_time");
        List<UserTest> list = userTestService.list(queryWrapper);
        return Result.success(list);
    }

    @GetMapping("/search/{query}")
    public Result search(@PathVariable String query) {
        log.info("搜索题目");
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<UserTest>();
        if (query.length() <= 4) {
            return getAll();
        }
        queryWrapper.like("testName", query.substring(4, query.length() - 1));
        queryWrapper.orderByDesc("create_time");
        List<UserTest> list = userTestService.list(queryWrapper);
        return Result.success(list);
    }

    @GetMapping("/{query}")
    public Result getDetail(@PathVariable String query) {
        log.info("得到指定题目详情");
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<UserTest>();
        queryWrapper.eq("testName", query);
        UserTest one = userTestService.getOne(queryWrapper);
        return Result.success(one.getDetail());
    }

    @PutMapping("/update/status")
    public Result read(@RequestBody TestUpdateDTO testUpdateDTO) {
        log.info("更新题目状态");
        if ("teacher".equals(testUpdateDTO.getRole())) {
            return Result.success("OK");
        }
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<UserTest>();
        queryWrapper.eq("testName", testUpdateDTO.getTestName());
        //queryWrapper.eq("student", testUpdateDTO.getUsername());
        UserTest one = userTestService.getOne(queryWrapper);
        one.setStatus(0);
        userTestService.update(one, queryWrapper);
        return Result.success("OK");
    }
}
