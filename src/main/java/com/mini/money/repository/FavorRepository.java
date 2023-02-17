package com.mini.money.repository;

import com.mini.money.entity.Customer;
import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorRepository extends JpaRepository<Favor, Long> {

    void deleteByCustomerAndLoan(Customer customer, Loan loan);


}