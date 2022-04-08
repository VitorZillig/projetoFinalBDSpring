package br.com.letscode.projetofinal.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
//import javax.
//import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String userName;
    private String password;
    private Boolean enabled;
    private List<String> roles;

}