package com.ekart.loginmodule.service;

import com.ekart.loginmodule.eo.Login;
import com.ekart.loginmodule.exception.InvalidUserNameAndPasswordException;
import com.ekart.loginmodule.exception.UserNotFoundException;
import com.ekart.loginmodule.repository.LoginRepository;
import com.ekart.loginmodule.util.AESEncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AESEncryptionDecryption aesEncryptionDecryption;
    @Autowired
    private LoginRepository loginRepository;


    @Override
    public Login checkUserExist(Login login)  throws UserNotFoundException{

        if(loginRepository.findByuserName(aesEncryptionDecryption.encrypt(login.getUserName()))==null)
        {
            throw new UserNotFoundException();
        }
        return loginRepository.findByuserName(aesEncryptionDecryption.encrypt(login.getUserName()));
    }

    @Override
    public Login validUserAndPassword(Login login) throws InvalidUserNameAndPasswordException {

         if(loginRepository.findByuserNameAndPassword(aesEncryptionDecryption.encrypt(login.getUserName()),
                    aesEncryptionDecryption.encrypt(login.getPassword()))==null)
            {
                throw new InvalidUserNameAndPasswordException();
            }
        return loginRepository.findByuserNameAndPassword(aesEncryptionDecryption.encrypt(login.getUserName()),
                aesEncryptionDecryption.encrypt(login.getPassword()));
    }

}
