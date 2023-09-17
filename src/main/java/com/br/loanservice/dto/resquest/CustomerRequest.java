package com.br.loanservice.dto.resquest;

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
    private Integer age;

    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal income;

    @NotBlank
    private String location;
}
