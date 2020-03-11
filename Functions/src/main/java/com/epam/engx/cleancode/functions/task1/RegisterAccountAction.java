package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {
    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        if (validateAccount(account)) {
            prepareAndRegisterAccount(account);
        }
    }

    private boolean validateAccount(Account account) {
        return validateAccountName(account.getName()) && validateAccountPassword(account.getPassword());
    }

    private boolean validateAccountName(String name) {
        return name.length() > 5;
    }

    private boolean validateAccountPassword(String password) {
        return validateAccountPasswordLength(password) && checkAccountPasswordCorrectness(password);
    }

    private boolean validateAccountPasswordLength(String password) {
        return password.length() > 8;
    }

    private boolean checkAccountPasswordCorrectness(String password) {
        return passwordChecker.validate(password) == OK;
    }

    private void prepareAndRegisterAccount(Account account) {
        prepareAccount(account);
        registerAccount(account);
    }

    private void prepareAccount(Account account) {
        account.setCreatedDate(new Date());
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
    }

    private void registerAccount(Account account) {
        accountManager.createNewAccount(account);
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

}
