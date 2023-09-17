package com.br.loanservice.enums;

import lombok.Getter;

@Getter
public enum Type {
    PERSONAL(0.04), GUARANTEED(0.03), CONSIGNMENT(0.02);


    Type(Double valueInterest) {
        this.valueInterest = valueInterest;
    }

    private Double valueInterest;

}
