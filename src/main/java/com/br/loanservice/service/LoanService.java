package com.br.loanservice.service;

import com.br.loanservice.mapper.LoanMapper;
import com.br.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

@Service
@XSlf4j
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final CustomerService customerService;
    private final LoanMapper mapper;
}
