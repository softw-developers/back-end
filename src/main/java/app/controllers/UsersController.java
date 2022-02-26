package app.controllers;

import app.models.UserRegisterModel;
import app.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @PostMapping("sign-in")
    public ResponseEntity<?> RegisterUser(@RequestBody UserRegisterModel userData) {
        usersService.RegisterUser(userData);
        return new ResponseEntity<>(userData, HttpStatus.CREATED);
    }

}
