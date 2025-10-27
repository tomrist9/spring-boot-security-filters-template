package com.walletwave.filterstemplate.controller;

import com.walletwave.filterstemplate.model.Customer;
import com.walletwave.filterstemplate.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        customer.setCreateDt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);

        if (savedCustomer.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User registered successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("User registration failed");
    }

    @GetMapping("/user")
    public ResponseEntity<Customer> getUserDetailsAfterLogin(Authentication authentication) {
        return customerRepository.findByEmail(authentication.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
