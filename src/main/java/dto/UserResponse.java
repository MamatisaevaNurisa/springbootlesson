package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class UserResponse {

    public Long id;
    public String userName;
    public String lastName;
    public String email;
    private String password;
    public String roleName;
    public LocalDate localDate;
}
