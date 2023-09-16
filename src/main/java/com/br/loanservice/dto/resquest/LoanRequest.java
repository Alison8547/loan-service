package com.br.loanservice.dto.resquest;

import com.br.loanservice.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequest {

    @NotBlank
    private Type type;

    @NotNull
    private BigDecimal valueLoan;

    @NotNull
    private Integer portion;


}
