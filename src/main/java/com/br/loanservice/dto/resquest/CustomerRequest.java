package com.br.loanservice.dto.resquest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    @NotNull
    @Schema(description = "Your age", example = "32")
    private Integer age;

    @NotBlank
    @Schema(description = "Your cpf", example = "872.377.100-36")
    private String cpf;

    @NotBlank
    @Schema(description = "Your name", example = "Diego")
    private String name;

    @NotNull
    @Schema(description = "Your income", example = "3422")
    private BigDecimal income;

    @NotBlank
    @Schema(description = "Your location", example = "SP")
    private String location;
}
