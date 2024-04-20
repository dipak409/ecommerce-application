package com.ekart.loginmodule.service;

import com.ekart.loginmodule.eo.SignUp;

public interface SignUpService  {
    //password update
    //mobile number update,email update
    //forget password
    //forget mobile number,email
    //email otp verification
    SignUp createUser(SignUp signUp);
}
