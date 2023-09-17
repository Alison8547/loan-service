package com.br.loanservice.service;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;
import com.br.loanservice.exception.BusinessException;
import com.br.loanservice.mapper.CustomerMapper;
import com.br.loanservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;


    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        if (customerRequest.getIncome().doubleValue() < 0) {
            throw new BusinessException("Income cannot be a negative value!");
        }

        if (customerRepository.existsByCpf(customerRequest.getCpf())) {
            throw new BusinessException("Cpf already exists!");
        }

        Customer customer = mapper.customerToEntity(customerRequest);
        customer.setIncome(customerRequest.getIncome().setScale(2, RoundingMode.CEILING));
        customerRepository.save(customer);
        log.info("Customer save success!");

        return mapper.customerToResponse(customer);
    }
}
