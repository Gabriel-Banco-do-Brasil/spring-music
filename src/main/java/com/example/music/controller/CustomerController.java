package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.exception.NotFoundException;
import com.example.music.model.Customer;
import com.example.music.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll() {

        List<Customer> returnedList = customerService.findAll();
        return ResponseEntity.ok(returnedList);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {

        try {
            Customer returnedCustomer = customerService.findById(id);
            return ResponseEntity.ok(returnedCustomer);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/createByEntity")
    public ResponseEntity<Customer> createByEntity(@RequestBody Customer customer) {

        customerService.createByEntity(customer);
        return ResponseEntity.ok(customer);

    }

    @PutMapping("/updateByEntity")
    public ResponseEntity<Customer> updateByEntity(@RequestBody Customer customer) {

        try {
            customerService.updateByEntity(customer);
            return ResponseEntity.ok(customer);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {

        try {
            customerService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
    
}
