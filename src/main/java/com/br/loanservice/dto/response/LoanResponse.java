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
public class LoanResponse {

    private Integer id;
    private Type type;
    private BigDecimal valueLoan;
    private Integer portion;
    private BigDecimal valueInterestRateLoan;
    private BigDecimal installmentPerMonth;
    private Double interestRate;
    private LocalDateTime timeLoan;

}
