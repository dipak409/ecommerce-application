package com.ekart.loginmodule.service;

import com.ekart.loginmodule.eo.Login;
import com.ekart.loginmodule.exception.InvalidUserNameAndPasswordException;
import com.ekart.loginmodule.exception.UserNotFoundException;

public interface LoginService {
    Login checkUserExist(Login login) throws UserNotFoundException;
    Login validUserAndPassword(Login login) throws InvalidUserNameAndPasswordException;

}
