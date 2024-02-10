package com.exception.homework.exception1.service;


import com.exception.homework.exception1.exception.WrongLoginException;
import com.exception.homework.exception1.exception.WrongPasswordException;

public interface RegistrationService {


    String registrationUser(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException;
}
