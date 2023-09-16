package com.br.loanservice.domain;

import com.br.loanservice.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table
@Entity(name = "LOAN")
public class Loan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "type_loan")
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column(name = "value_loan")
    private BigDecimal valueLoan;

    @Column(name = "portion")
    private Integer portion;

    @Column(name = "value_interest_rate")
    private BigDecimal valueInterestRate;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "time_loan")
    private LocalDateTime timeLoan;

    @Column(name = "id_customer", insertable = false, updatable = false)
    private Integer idCustomer;


    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;


}
