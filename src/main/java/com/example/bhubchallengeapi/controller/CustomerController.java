package com.example.bhubchallengeapi.controller;

import com.example.bhubchallengeapi.dto.CustomerDTO;
import com.example.bhubchallengeapi.mapper.CustomerMapper;
import com.example.bhubchallengeapi.model.Customer;
import com.example.bhubchallengeapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;
    private CustomerMapper mapper;

    public CustomerController(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<Customer> retorno = service.getAllCustomers();
        return ResponseEntity.ok(mapper.customerEntityListToCustomerDtoList(retorno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@RequestParam Long id){
        Optional<Customer> retorno = service.getCustomerById(id);
        return retorno.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(mapper.customerEntityToDto(retorno.get()));

    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@Valid @RequestBody CustomerDTO customer){
        return new ResponseEntity<>(mapper.customerEntityToDto(service.saveCustomer(mapper.customerDtoToEntity(customer))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestParam Long id, @RequestBody CustomerDTO customer){
        Optional<Customer> response = service.updateCustomer(mapper.customerDtoToEntity(customer), id);
        if(response.isEmpty())
        return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(mapper.customerEntityToDto(response.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@RequestParam Long id){
        boolean response = service.deleteCustomer(id);
        return response ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }
}
