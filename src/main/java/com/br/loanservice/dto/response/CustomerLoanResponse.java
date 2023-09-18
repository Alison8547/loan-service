package com.br.loanservice.dto.response;

import com.br.loanservice.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLoanResponse {

    private Integer idCustomer;
    private String name;
    private BigDecimal income;
    private String location;
    private Integer idLoan;
    private Type type;
    private BigDecimal valueLoan;
    private Integer portion;
    private BigDecimal valueInterestRateLoan;
    private BigDecimal installmentPerMonth;
    private Double interestRate;
    private LocalDateTime timeLoan;
}
