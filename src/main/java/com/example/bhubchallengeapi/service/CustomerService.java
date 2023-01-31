package com.example.bhubchallengeapi.service;

import com.example.bhubchallengeapi.model.Customer;
import com.example.bhubchallengeapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        setCustomerToBankList(customer);
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public Optional<Customer> updateCustomer(Customer customer, Long id) {
        Optional<Customer> saved = repository.findById(id);
        saved.ifPresent(s -> {
            s.getAddress().setPostalCode(customer.getAddress().getPostalCode());
            s.getAddress().setStreet(customer.getAddress().getStreet());
            s.getAddress().setNumber(customer.getAddress().getNumber());
            s.getAddress().setCountry(customer.getAddress().getCountry());
            s.getAddress().setCity(customer.getAddress().getCity());
            s.setCompanyName(customer.getCompanyName());
            s.setTelephone(customer.getTelephone());
            s.setDeclaredBilling(customer.getDeclaredBilling());
            s.setBankDataList(customer.getBankDataList());
            setCustomerToBankList(s);
            repository.save(s);
        });
        return saved;
    }

    private void setCustomerToBankList(Customer customer) {
        customer.getBankDataList().forEach(bankData -> bankData.setCustomer(customer));
    }

    public boolean deleteCustomer(Long id) {
        if(repository.existsById(id)){
        repository.deleteById(id);
        return true;
        }else
            return false;
    }
}
