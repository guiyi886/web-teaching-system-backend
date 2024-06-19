package teaching.system.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import teaching.system.backend.domain.dto.LoginDTO;
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
}
