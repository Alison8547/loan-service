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

    @Column(name = "age_customer")
    private Integer age;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name_customer")
    private String name;

    @Column(name = "income")
    private BigDecimal income;

    @Column(name = "location_customer")
    private String location;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();
}
