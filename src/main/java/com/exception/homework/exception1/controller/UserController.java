package com.exception.homework.exception1.controller;

import com.exception.homework.exception1.exception.WrongLoginException;
import com.exception.homework.exception1.exception.WrongPasswordException;
import com.exception.homework.exception1.service.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class UserController {
    private final RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/registration")
    public String getRegistrationUser(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {

        try {
            final String user = registrationService.registrationUser(login, password, confirmPassword);


        } catch (WrongLoginException e) {
            e.printStackTrace();
            return "Логин может состоять только из латинских букв,_, и цифр размер не более 20 символов";

        } catch (WrongPasswordException e) {
            e.printStackTrace();


            return "Пароль может состоять только из латинских букв,_, и цифр размер не более 20 символов";
        }
        return "логин " + login + " пароль " + password;
    }
}