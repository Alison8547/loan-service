package com.br.loanservice.enums;

import lombok.Getter;

@Getter
public enum Type {
    PERSONAL(4), GUARANTEED(3), CONSIGNMENT(2);


    Type(Integer valueInterest) {
        this.valueInterest = valueInterest;
    }

    private Integer valueInterest;

}
