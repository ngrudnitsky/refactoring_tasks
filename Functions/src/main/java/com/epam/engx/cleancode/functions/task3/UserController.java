package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;

public abstract class UserController implements Controller {

    private UserAuthenticator userAuthenticator;

    public void authenticateUser(String userName, String password) {
        try {
            userAuthenticator.login(userName, password);
            generateSuccessLoginResponse(userName);
        } catch (LoginException e) {
            generateFailLoginResponse();
        }
    }

    public UserController(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
