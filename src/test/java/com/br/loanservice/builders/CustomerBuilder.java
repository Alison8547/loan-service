package com.br.loanservice.builders;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.dto.response.CustomerLoanResponse;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;
import com.br.loanservice.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public static CustomerLoanResponse newCustomerBuilderCustomerLoanResponse() {
        return CustomerLoanResponse.builder()
                .idCustomer(1)
                .idLoan(2)
                .name("Alison")
                .timeLoan(LocalDateTime.now())
                .location("SP")
                .valueLoan(BigDecimal.valueOf(2333))
                .type(Type.PERSONAL)
                .income(BigDecimal.valueOf(3000))
                .interestRate(Type.PERSONAL.getValueInterest())
                .portion(12)
                .installmentPerMonth(BigDecimal.valueOf(4555))
                .valueInterestRateLoan(BigDecimal.valueOf(4333))
                .build();
    }

}
