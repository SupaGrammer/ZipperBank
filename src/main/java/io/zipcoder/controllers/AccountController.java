package io.zipcoder.controllers;

import io.zipcoder.DAOs.Account;
import io.zipcoder.repos.AccountRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

@RestController
public class AccountController {
    //Here is where we put all our request methods that are in the colorful chart at the bottom of the page
    @Inject
    private AccountRepository accountRepository;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts(){
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){
        Account account = accountRepository.findOne(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccountsByCustomer(@PathVariable Long customerId){
        Iterable<Account> accounts = accountRepository.findAllAccountsByCustomer(customerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@PathVariable int customerId, @RequestBody Account account) {
        account = accountRepository.save(account);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long accountId, @RequestBody Account account){
        Account a = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
