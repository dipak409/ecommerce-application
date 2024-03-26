package com.ekart.loginmodule.eo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;


}
