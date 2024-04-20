package com.ekart.loginmodule.service;

import com.ekart.loginmodule.eo.Login;
import com.ekart.loginmodule.eo.SignUp;
import com.ekart.loginmodule.repository.LoginRepository;
import com.ekart.loginmodule.repository.SignUpRepository;
import com.ekart.loginmodule.util.AESEncryptionDecryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private LoginRepository loginRepository;

//    private Login login;

    @Autowired
    private AESEncryptionDecryption aesEncryptionDecryption;
    @Override
    public SignUp createUser(SignUp signUp) {

        loginRepository.save(Login.builder().userName(aesEncryptionDecryption.encrypt(signUp.getUserName())).password(aesEncryptionDecryption.encrypt(signUp.getPassword())).build());
        return signUpRepository.save(SignUp.builder().userName(aesEncryptionDecryption.encrypt(signUp.getUserName())).password(aesEncryptionDecryption.encrypt(signUp.getPassword())).mobileNumber(signUp.getMobileNumber()).email(signUp.getEmail()).build());
    }


//    @Override
//    public SignUp checkUserExist(LoginDao login) {
//
//        return signUpRepository.findByuserName(login.getUserName());
//    }
}
