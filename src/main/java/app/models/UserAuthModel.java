package app.models;

import lombok.Data;

@Data
public class UserAuthModel {
    private Long id;
    private String token;

    public UserAuthModel(Long id) {
        this.id = id;
    }
}
