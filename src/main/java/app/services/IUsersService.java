package app.services;


import app.models.ApiError;
import app.models.UserAuthModel;
import app.models.UserRegisterModel;

public interface IUsersService {
    UserAuthModel RegisterUser(UserRegisterModel user) throws ApiError;
}
