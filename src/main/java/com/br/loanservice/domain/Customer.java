package com.br.loanservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table
@Entity(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf")
    private String cpf;
    @Column(name = "name")
    private String name;

    @Column(name = "income")
    private BigDecimal income;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Loan> loas = new ArrayList<>();
}
