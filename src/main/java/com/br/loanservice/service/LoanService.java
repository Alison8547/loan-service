package com.br.loanservice.service;

import com.br.loanservice.dto.response.LoanResponse;
import com.br.loanservice.dto.resquest.LoanRequest;
import com.br.loanservice.mapper.LoanMapper;
import com.br.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final CustomerService customerService;
    private final LoanMapper mapper;


    public LoanResponse openLoan(Integer idCustomer, LoanRequest loanRequest) {
        return null;
    }
}
