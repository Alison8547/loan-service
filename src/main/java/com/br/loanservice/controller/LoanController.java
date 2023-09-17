package com.br.loanservice.controller;

import com.br.loanservice.dto.response.LoanResponse;
import com.br.loanservice.dto.resquest.LoanRequest;
import com.br.loanservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/open-loan/{idCustomer}")
    public ResponseEntity<LoanResponse> openLoan(@PathVariable(name = "idCustomer") Integer idCustomer, @RequestBody @Valid LoanRequest loanRequest) {
        return new ResponseEntity<>(loanService.openLoan(idCustomer, loanRequest), HttpStatus.CREATED);
    }
}
