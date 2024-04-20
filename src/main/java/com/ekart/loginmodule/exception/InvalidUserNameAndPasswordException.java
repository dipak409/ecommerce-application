package com.ekart.loginmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Invalid User Name or Password")
public class InvalidUserNameAndPasswordException extends Exception{
}
