package com.br.loanservice.mapper;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final ModelMapper modelMapper;


    public Customer customerToEntity(CustomerRequest customerRequest) {
        return modelMapper.map(customerRequest, Customer.class);
    }

    public CustomerResponse customerToResponse(Customer customer) {
        return modelMapper.map(customer, CustomerResponse.class);
    }
}
