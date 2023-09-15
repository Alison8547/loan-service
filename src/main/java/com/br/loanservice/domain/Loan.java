package com.br.loanservice.domain;

import com.br.loanservice.enums.Type;
import lombok.*;

import javax.persistence.*;

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


    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "id_customer", insertable = false, updatable = false)
    private Integer idCustomer;


    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;


}
