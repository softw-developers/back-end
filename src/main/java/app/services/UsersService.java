package app.services;

import app.entities.RegisterType;
import app.entities.User;
import app.models.UserRegisterModel;
import app.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void RegisterUser(UserRegisterModel user) {
        User userToSave = modelMapper.map(user, User.class);
        userToSave.setRegisterType(new RegisterType(user.getIdRegisterType()));
        userRepository.save(userToSave);
    }
}
