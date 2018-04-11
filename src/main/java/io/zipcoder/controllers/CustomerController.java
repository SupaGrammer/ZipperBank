package io.zipcoder.controllers;

import io.zipcoder.DAOs.Account;
import io.zipcoder.DAOs.Customer;
import io.zipcoder.repos.AccountRepository;
import io.zipcoder.repos.CustomerRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

@RestController
public class CustomerController  {

    @Inject
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCusOnAccount(@PathVariable Long accountId){
        Customer customer = accountRepository.findOne(accountId).getCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCusByID(@PathVariable Long id){
        Customer customer = customerRepository.findOne(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer){
        customer = customerRepository.save(customer);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        HttpHeaders H = new HttpHeaders();
        H.setLocation(newAccountUri);
        return new ResponseEntity<>(H, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer c = customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
