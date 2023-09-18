package com.br.loanservice.controller;

import com.br.loanservice.dto.response.CustomerLoanResponse;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;
import com.br.loanservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create-customer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/list-customer-loan")
    public ResponseEntity<List<CustomerLoanResponse>> listCustomerLoan(@RequestParam(required = false) Integer idCustomer) {
        return new ResponseEntity<>(customerService.listCustomerLoan(idCustomer), HttpStatus.OK);
    }
}
