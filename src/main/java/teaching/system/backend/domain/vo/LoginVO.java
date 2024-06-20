package teaching.system.backend.domain.vo;

import lombok.Data;

@Data
public class LoginVO {
    private int id;
    private String account;
    private String role;
    private String username;
    private String email;
    private String phone;
    private int status;
}
