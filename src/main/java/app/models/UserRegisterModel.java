package app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterModel {

    @JsonProperty("first_name")
    @NotBlank(message = "First name is required.")
    @NotNull(message = "First name cannot be empty.")
    @Size(min = 1, max = 200, message = "First name must be between 1 and 200 characters.")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "Last name is required.")
    @NotNull(message = "Last name cannot be empty.")
    @Size(min = 1, max = 200, message = "Last name must be between 1 and 200 characters.")
    private String lastName;

    @JsonProperty("id_register_type")
    @NotNull(message = "Register type cannot be empty.")
    @Min(value = 1, message = "Register type id must be greater than 0.")
    private Long idRegisterType;

    @NotBlank(message = "Email is required.")
    @NotNull(message = "Email cannot be empty.")
    @Size(min = 1, max = 255, message = "Email must be between 1 and 255 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email format is invalid.")
    private String email;

    @NotBlank(message = "Password is required.")
    @NotNull(message = "Password cannot be empty.")
    @Size(min = 1, max = 255, message = "Password must be between 1 and 255 characters.")
    //TODO: COMPLETAR ESTO!!!
//    @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$",
//            message = "The password must have at least one number," +
//                    "one capital letter and be between 8 and 20 characters.")
    private String password;
}
