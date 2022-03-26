package app.services;

import app.entities.RegisterType;
import app.entities.User;
import app.models.ApiError;
import app.models.UserAuthModel;
import app.models.UserRegisterModel;
import app.repositories.IRegisterTypeRepository;
import app.repositories.IUserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements IUsersService{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRegisterTypeRepository registerTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserAuthModel RegisterUser(UserRegisterModel user) throws ApiError {
        Optional<User> userExist = userRepository.getByEmail(user.getEmail());
        if (userExist.isPresent()) {
            throw new ApiError("The user has been already registered.", HttpStatus.BAD_REQUEST);
        }

        Optional<RegisterType> registerTypeExist = registerTypeRepository.findById(user.getIdRegisterType());
        if (registerTypeExist.isEmpty()) {
            throw new ApiError("The user register type not exists.", HttpStatus.BAD_REQUEST);
        }

        //TODO: mejorar esta ranciada
        User userToSave = modelMapper.map(user, User.class);
        userToSave.setId(null);
        userToSave.setPassword(encodePassword(user.getPassword()));

        User userSaved = userRepository.save(userToSave);
        UserAuthModel userAuth = new UserAuthModel(userSaved.getId());
        userAuth.setToken(getJWTToken(userAuth));
        return userAuth;
    }

    //TODO: Hacer metodo de login

    private String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(Arrays.toString(password.toCharArray()));
    }

    private boolean isPasswordMatches(String inputPassword, String passwordInDb) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(Arrays.toString(inputPassword.toCharArray()), passwordInDb);
    }

    private String getJWTToken(UserAuthModel user) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("");

        String token = Jwts
                .builder()
                .setSubject(user.getId().toString())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
