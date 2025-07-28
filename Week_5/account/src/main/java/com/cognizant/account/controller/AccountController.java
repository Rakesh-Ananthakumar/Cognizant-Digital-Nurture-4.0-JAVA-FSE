package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable String number) {
        // Creating a dummy account object without any backend connectivity
        Account account = new Account(number, "savings", 234343.0);
        return account;
    }
}
