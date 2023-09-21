package com.br.loanservice.tests;

import com.br.loanservice.builders.CustomerBuilder;
import com.br.loanservice.mapper.CustomerMapper;
import com.br.loanservice.repository.CustomerRepository;
import com.br.loanservice.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper mapper;

    @Test
    public void testMustCreateCustomerWithSuccess() {
        //(SETUP)
        when(customerRepository.save(any())).thenReturn(CustomerBuilder.newCustomerBuilderEntity());
        when(mapper.customerToEntity(any())).thenReturn(CustomerBuilder.newCustomerBuilderEntity());
        when(mapper.customerToResponse(any())).thenReturn(CustomerBuilder.newCustomerBuilderResponse());

        //(ACT)
        customerService.createCustomer()

        //(ASSERT)


    }
}
