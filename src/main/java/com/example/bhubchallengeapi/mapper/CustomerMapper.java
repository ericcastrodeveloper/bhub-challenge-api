package com.example.bhubchallengeapi.mapper;

import com.example.bhubchallengeapi.dto.CustomerDTO;
import com.example.bhubchallengeapi.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    CustomerDTO customerEntityToDto(Customer customer);
    Customer customerDtoToEntity(CustomerDTO customerDTO);
    List<CustomerDTO> customerEntityListToCustomerDtoList(List<Customer> customers);
    List<Customer> customerDtoListToCustomerEntityList(List<CustomerDTO> customers);
}
