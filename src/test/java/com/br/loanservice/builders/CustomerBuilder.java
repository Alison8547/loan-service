package com.br.loanservice.builders;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;

import java.math.BigDecimal;

public class CustomerBuilder {

    public static Customer newCustomerBuilderEntity() {
        return Customer.builder()
                .id(1)
                .name("Alison")
                .age(34)
                .cpf("872.377.100-36")
                .income(BigDecimal.valueOf(3000.0))
                .location("SP")
                .build();
    }

    public static CustomerResponse newCustomerBuilderResponse() {
        return CustomerResponse.builder()
                .id(1)
                .name("Alison")
                .income(BigDecimal.valueOf(3000.0))
                .location("SP")
                .build();
    }

    public static CustomerRequest newCustomerBuilderRequest() {
        return CustomerRequest.builder()
                .name("Alison")
                .age(34)
                .cpf("872.377.100-36")
                .income(BigDecimal.valueOf(3000.0))
                .location("SP")
                .build();
    }

    public static CustomerRequest newCustomerBuilderRequestIncomeNegative() {
        return CustomerRequest.builder()
                .name("Alison")
                .age(34)
                .cpf("872.377.100-36")
                .income(BigDecimal.valueOf(-3000.0))
                .location("SP")
                .build();
    }


}
