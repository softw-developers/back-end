package app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class UserRegisterModel {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("register_type")
    private Integer registerType;

    private String email;

    private String password;
}
