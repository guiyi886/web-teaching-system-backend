package teaching.system.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDTO {
    private String account;

    @JsonProperty("hashed_password")
    private String hashedPassword;
}
