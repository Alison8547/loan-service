package com.br.loanservice.builders;

import com.br.loanservice.domain.Customer;

import java.math.BigDecimal;

public class CustomerBuilder {

    public static Customer newCustomerBuilderEntity() {
        return Customer.builder()
                .id(2)
                .name("Alison")
                .age(34)
                .cpf("872.377.100-36")
                .income(BigDecimal.valueOf(3000.0))
                .location("SP")
                .build();
    }


    public static Customer newCustomerBuilderEntityIncomeNegative() {
        return Customer.builder()
                .id(2)
                .name("Alison")
                .age(34)
                .cpf("872.377.100-36")
                .income(BigDecimal.valueOf(-2333.0))
                .location("SP")
                .build();
    }

}
