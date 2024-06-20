package teaching.system.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teaching.system.backend.domain.dto.LoginDTO;
import teaching.system.backend.domain.dto.UpdateInfoDTO;
import teaching.system.backend.domain.po.User;
import teaching.system.backend.result.Result;
import teaching.system.backend.service.impl.UserServiceImpl;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping("login")
    public Result login(@RequestBody @Validated LoginDTO loginDTO) {
        log.info("登录尝试:{}", loginDTO);

        return Result.success(userServiceImpl.login(loginDTO), "登录成功!");
    }

    @PostMapping("updateInfo")
    public Result updateInfo(@RequestBody @Validated UpdateInfoDTO updateInfoDTO) {
        log.info("修改尝试:{}", updateInfoDTO);
        userServiceImpl.updateInfo(updateInfoDTO);
        return Result.success(null, "修改成功!");
    }

    @PostMapping("register")
    public Result updateInfo(@RequestBody @Validated User user) {
        log.info("注册尝试:{}", user);
        //userServiceImpl.register(user);
        //return Result.success("注册成功!");
        String msg = userServiceImpl.register(user);
        if ("注册成功".equals(msg)) {
            return Result.success(null, "注册成功!");
        } else {
            return Result.error(msg);
        }
    }

    @GetMapping("students")
    public Result getStudents() {
        log.info("获取学生列表尝试:");
        return Result.success(userServiceImpl.getStudents());
    }

    @PutMapping("/resetPassword/{account}")
    public Result resetPassword(@PathVariable String account) {
        userServiceImpl.resetPassword(account);
        return Result.success(null, "重置密码成功！");
    }

    @PutMapping("/disable/{account}")
    public Result disableStudent(@PathVariable String account) {
        userServiceImpl.disableStudent(account);
        return Result.success(null, "禁用账号成功！");
    }

    @PutMapping("/enable/{account}")
    public Result enableStudent(@PathVariable String account) {
        userServiceImpl.enableStudent(account);
        return Result.success(null, "启用成功！");
    }

    @DeleteMapping("delete/{account}")
    public Result deleteStudent(@PathVariable String account) {
        userServiceImpl.deleteStudent(account);
        return Result.success(null, "删除账号成功！");
    }
}
