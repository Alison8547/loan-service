package com.br.loanservice.dto.resquest;

import com.br.loanservice.enums.Type;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequest {

    @NotNull
    @Schema(description = "Type loan", example = "PERSONAL")
    private Type type;

    @NotNull
    @Schema(description = "Value loan", example = "2000")
    private BigDecimal valueLoan;

    @NotNull
    @Schema(description = "Portion loan", example = "12")
    private Integer portion;


}
