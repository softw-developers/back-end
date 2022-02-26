package app.services;

import app.models.UserRegisterModel;
import app.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void RegisterUser(UserRegisterModel user) {
        userRepository.save(user);
    }
}
