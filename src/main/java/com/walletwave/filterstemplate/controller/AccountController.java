package com.walletwave.filterstemplate.controller;


import com.walletwave.filterstemplate.model.Accounts;
import com.walletwave.filterstemplate.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountsRepository accountRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam long id){
        Accounts accounts = accountRepository.findByCustomerId(id);
        if(accounts!=null){
            return accounts;
        }else {
            return null;
        }
    }
}
