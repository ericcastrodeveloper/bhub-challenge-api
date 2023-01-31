package com.example.bhubchallengeapi.service;

import com.example.bhubchallengeapi.mock.CustomerMock;
import com.example.bhubchallengeapi.model.Customer;
import com.example.bhubchallengeapi.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;
    @Mock
    private CustomerRepository repository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllCostumers(){
        when(repository.findAll()).thenReturn(Arrays.asList(CustomerMock.getMock()));
        List<Customer> response = service.getAllCustomers();
        assertEquals(response.size(), 1);
    }

    @Test
    public void shouldReturnACostumer(){
        when(repository.findById(anyLong())).thenReturn(Optional.of(CustomerMock.getMock()));
        Optional<Customer> response = service.getCustomerById(1L);
        assertEquals(response.get().getId(), 1);
    }

    @Test
    public void shouldCreateACostumer(){
        when(repository.save(any(Customer.class))).thenReturn(CustomerMock.getMock());
        Customer response = service.saveCustomer(CustomerMock.getMock());
        assertEquals(response.getId(), 1);
    }

    @Test
    public void shouldUpdateACostumer(){
        when(repository.save(any(Customer.class))).thenReturn(CustomerMock.getMock());
        when(repository.findById(anyLong())).thenReturn(Optional.of(CustomerMock.getMock()));
        Optional<Customer> response = service.updateCustomer(CustomerMock.getMock(), 1L);
        assertEquals(response.get().getId(), 1);
    }

    @Test
    public void shouldDeleteACostumer(){
        when(repository.existsById(anyLong())).thenReturn(true);
        boolean response = service.deleteCustomer(1L);
        assertEquals(response, true);
    }

    @Test
    public void shouldNotDeleteACostumer(){
        when(repository.existsById(anyLong())).thenReturn(false);
        boolean response = service.deleteCustomer(1L);
        assertEquals(response, false);
    }
}
