package com.ekart.loginmodule.controller;

import com.ekart.loginmodule.eo.Login;
import com.ekart.loginmodule.eo.SignUp;
import com.ekart.loginmodule.exception.InvalidUserNameAndPasswordException;
import com.ekart.loginmodule.exception.UserNotFoundException;
import com.ekart.loginmodule.service.LoginService;
import com.ekart.loginmodule.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpController {
//username, password encrypt

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<SignUp> create(@RequestBody SignUp signUp)
    {
        return new ResponseEntity<>(signUpService.createUser(signUp), HttpStatus.OK);
    }

    @PostMapping("/checkuser")
    public ResponseEntity<Login> login(@RequestBody Login login) throws UserNotFoundException {
        return new ResponseEntity<>(loginService.checkUserExist(login), HttpStatus.OK);
    }

    @PostMapping("/valid")
    public ResponseEntity<Login> valid(@RequestBody Login login) throws InvalidUserNameAndPasswordException {
        return new ResponseEntity<>(loginService.validUserAndPassword(login), HttpStatus.OK);
    }

}
