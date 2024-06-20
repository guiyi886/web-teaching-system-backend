package teaching.system.backend.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String account;
    private String role;
    private String salt;
    private String saltHashedPassword;
    private String username;
    private String email;
    private String phone;
    private String identity;
    private int status;
}
