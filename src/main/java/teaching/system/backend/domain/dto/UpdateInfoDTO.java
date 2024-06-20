package teaching.system.backend.domain.dto;

import lombok.Data;

@Data
public class UpdateInfoDTO {
    private String account;
    private String email;
    private String phone;
}
