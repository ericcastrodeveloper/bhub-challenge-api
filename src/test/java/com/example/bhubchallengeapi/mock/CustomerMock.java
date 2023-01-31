package com.example.bhubchallengeapi.mock;
import com.example.bhubchallengeapi.dto.AddressDTO;
import com.example.bhubchallengeapi.dto.BankDataDTO;
import java.util.ArrayList;

import com.example.bhubchallengeapi.dto.CustomerDTO;
import com.example.bhubchallengeapi.model.Address;
import com.example.bhubchallengeapi.model.BankData;
import com.example.bhubchallengeapi.model.Customer;

import java.time.LocalDate;
import java.util.Arrays;

public class CustomerMock {

    public static Customer getMock(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCompanyName("");
        customer.setTelephone("");
        customer.setEmail("");
        customer.setAddress(new Address());
        customer.setDeclaredBilling("");
        customer.setCreatedDate(LocalDate.now());
        customer.setUpdatedDate(LocalDate.now());
        BankData bankData = new BankData();
        bankData.setAgencie("");
        bankData.setAccount("");
        bankData.setNumberBank("");
        bankData.setCustomer(new Customer());

        customer.setBankDataList(Arrays.asList(bankData));

        return customer;
    }

    public static CustomerDTO getMockDto(){
        CustomerDTO customerDTO = new CustomerDTO();
        AddressDTO addressDTO = new AddressDTO();
        BankDataDTO bankDataDTO = new BankDataDTO();

        customerDTO.setCompanyName("test");
        customerDTO.setTelephone("123456789");
        customerDTO.setEmail("test@test.com");
        addressDTO.setPostalCode("123456789");
        addressDTO.setStreet("Street Test");
        addressDTO.setNumber("1234");
        addressDTO.setCountry("Country Test");
        addressDTO.setCity("City Test");

        customerDTO.setAddress(addressDTO);
        customerDTO.setDeclaredBilling("");
        customerDTO.setCreatedDate(LocalDate.now());
        customerDTO.setUpdatedDate(LocalDate.now());

        bankDataDTO.setAgencie("1234");
        bankDataDTO.setAccount("123456");
        bankDataDTO.setNumberBank("123");

        customerDTO.setBankDataList(Arrays.asList(bankDataDTO));
        return customerDTO;
    }
}
