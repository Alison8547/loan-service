package com.br.loanservice.mapper;

import com.br.loanservice.domain.Loan;
import com.br.loanservice.dto.response.LoanResponse;
import com.br.loanservice.dto.resquest.LoanRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final ModelMapper modelMapper;

    public Loan loanToEntity(LoanRequest loanRequest) {
        return modelMapper.map(loanRequest, Loan.class);
    }

    public LoanResponse loanToResponse(Loan loan) {
        return modelMapper.map(loan, LoanResponse.class);
    }
}
