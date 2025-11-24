package com.mk.springboot.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.springboot.bean.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	Optional<Loan> findByLoanId(Long loanId);

}
