package com.example.bhubchallengeapi.controller;

import com.example.bhubchallengeapi.dto.CustomerDTO;
import com.example.bhubchallengeapi.mapper.CustomerMapper;
import com.example.bhubchallengeapi.mock.CustomerMock;
import com.example.bhubchallengeapi.model.Customer;
import com.example.bhubchallengeapi.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    @InjectMocks
    private CustomerController controller;
    @Mock
    private CustomerService service;
    @Mock
    private CustomerMapper mapper;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllCostumers(){
        when(service.getAllCustomers()).thenReturn(Arrays.asList(CustomerMock.getMock()));
        ResponseEntity<List<CustomerDTO>> response = controller.getAllCustomers();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldReturnACostumer(){
        when(service.getCustomerById(anyLong())).thenReturn(Optional.of(CustomerMock.getMock()));
        ResponseEntity<?> response = controller.getCustomerById(1L);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void shouldNotReturnACostumer(){
        when(service.getCustomerById(anyLong())).thenReturn(Optional.empty());
        ResponseEntity<?> response = controller.getCustomerById(1L);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void shouldCreateNewCostumer(){
        when(service.saveCustomer(any(Customer.class))).thenReturn(CustomerMock.getMock());
        ResponseEntity<CustomerDTO> response = controller.saveCustomer(CustomerMock.getMockDto());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void shouldUpdateACostumer(){
        when(service.updateCustomer(any(Customer.class), anyLong())).thenReturn(Optional.of(CustomerMock.getMock()));
        when(mapper.customerDtoToEntity(any(CustomerDTO.class))).thenReturn(CustomerMock.getMock());
        ResponseEntity<CustomerDTO> response = controller.updateCustomer(1L, CustomerMock.getMockDto());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldNotUpdateACostumer(){
        when(service.updateCustomer(any(Customer.class), anyLong())).thenReturn(Optional.empty());
        when(mapper.customerDtoToEntity(any(CustomerDTO.class))).thenReturn(CustomerMock.getMock());
        ResponseEntity<CustomerDTO> response = controller.updateCustomer(1L, CustomerMock.getMockDto());
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void shouldDeleteACostumer(){
        when(service.deleteCustomer(anyLong())).thenReturn(true);
        ResponseEntity<Void> response = controller.deleteCustomer(1L);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldNotDeleteACostumer(){
        when(service.deleteCustomer(anyLong())).thenReturn(false);
        ResponseEntity<Void> response = controller.deleteCustomer(1L);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
