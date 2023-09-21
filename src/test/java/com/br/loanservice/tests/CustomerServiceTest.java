package com.br.loanservice.tests;

import com.br.loanservice.builders.CustomerBuilder;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.exception.BusinessException;
import com.br.loanservice.mapper.CustomerMapper;
import com.br.loanservice.repository.CustomerRepository;
import com.br.loanservice.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

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
        CustomerResponse customer = customerService.createCustomer(CustomerBuilder.newCustomerBuilderRequest());

        //(ASSERT)
        assertNotNull(customer);
        assertEquals(1, customer.getId());
        assertEquals("Alison", customer.getName());
        assertEquals(BigDecimal.valueOf(3000.0), customer.getIncome());

    }

    @Test(expected = BusinessException.class)
    public void testMustCreateCustomerErrorIncomeNegative() {
        //(SETUP)

        //(ACT)
        CustomerResponse customer = customerService.createCustomer(CustomerBuilder.newCustomerBuilderRequestIncomeNegative());

        //(ASSERT)
        assertNotNull(customer);
        assertThrows(BusinessException.class, () -> customerService.createCustomer(CustomerBuilder.newCustomerBuilderRequestIncomeNegative()));

    }

    @Test(expected = BusinessException.class)
    public void testMustCreateCustomerErrorCpfAlreadyExists() {
        //(SETUP)
        when(customerRepository.existsByCpf(any())).thenReturn(true);
        //(ACT)
        CustomerResponse customer = customerService.createCustomer(CustomerBuilder.newCustomerBuilderRequest());

        //(ASSERT)
        assertNotNull(customer);
        assertThrows(BusinessException.class, () -> customerService.createCustomer(CustomerBuilder.newCustomerBuilderRequest()));

    }
}
