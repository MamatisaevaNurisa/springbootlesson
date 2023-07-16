package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    public String userName;
    public String lastName;
    public String email;
    private String password;
    public String roleName;
}
