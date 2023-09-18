package com.br.loanservice.repository;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.dto.response.CustomerLoanResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByCpf(String cpf);

    @Query(" select new com.br.loanservice.dto.response.CustomerLoanResponse(" +
            " c.id," +
            " c.name," +
            " c.income," +
            " c.location," +
            " l.id," +
            " l.type," +
            " l.valueLoan," +
            " l.portion," +
            " l.valueInterestRateLoan," +
            " l.installmentPerMonth," +
            " l.interestRate," +
            " l.timeLoan" +
            ")" +
            " from CUSTOMER c left join LOAN l on l.idCustomer = c.id " +
            " where :idCustomer is null or c.id = :idCustomer")
    List<CustomerLoanResponse> listCustomerLoan(@Param("idCustomer") Integer idCustomer);
}
