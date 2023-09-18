package com.br.loanservice.service;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.domain.Loan;
import com.br.loanservice.dto.response.LoanResponse;
import com.br.loanservice.dto.resquest.LoanRequest;
import com.br.loanservice.enums.Type;
import com.br.loanservice.exception.BusinessException;
import com.br.loanservice.mapper.LoanMapper;
import com.br.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
@Log4j2
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final CustomerService customerService;
    private final LoanMapper mapper;


    public LoanResponse openLoan(Integer idCustomer, LoanRequest loanRequest) {
        Loan loan = mapper.loanToEntity(loanRequest);
        Customer customer = customerService.findCustomer(idCustomer);

        if (loanRequest.getType().equals(Type.PERSONAL)) {
            if (!(customer.getIncome().doubleValue() <= 3000.00 && customer.getAge() < 30 && customer.getLocation().equals("SP"))) {
                throw new BusinessException("It is not possible to make this type of loan PERSONAL");
            }

        }

        if (loanRequest.getType().equals(Type.CONSIGNMENT)) {
            if (!(customer.getIncome().doubleValue() > 3000.00 && customer.getIncome().doubleValue() <= 5000.00)) {
                throw new BusinessException("It is not possible to make this type of loan CONSIGNMENT");
            }

        }

        if (loanRequest.getType().equals(Type.GUARANTEED)) {
            if (!(customer.getIncome().doubleValue() > 5000.00)) {
                throw new BusinessException("It is not possible to make this type of loan GUARANTEED");
            }
        }

        loan.setInterestRate(loanRequest.getType().getValueInterest());
        loan.setTimeLoan(LocalDateTime.now());
        loan.setIdCustomer(customer.getId());
        loan.setCustomer(customer);
        loan.setValueLoan(loanRequest.getValueLoan().setScale(2, RoundingMode.CEILING));

        BigDecimal valueTerm = loanRequest.getValueLoan().divide(new BigDecimal(loanRequest.getPortion()), 2, RoundingMode.CEILING);
        BigDecimal multiplyRate = loanRequest.getValueLoan().multiply(BigDecimal.valueOf(loanRequest.getType().getValueInterest()).setScale(2, RoundingMode.CEILING));
        loan.setInstallmentPerMonth(multiplyRate.add(valueTerm));
        loan.setValueInterestRateLoan(multiplyRate.add(valueTerm).multiply(new BigDecimal(loanRequest.getPortion())));

        loanRepository.save(loan);
        log.info("Open loan successful!");

        return mapper.loanToResponse(loan);
    }

    public Loan findLoan(Integer id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Not found loan!"));
    }

}




