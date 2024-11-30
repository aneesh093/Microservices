package com.talkytech.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Loans extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private BigDecimal totalLoan;

    private BigDecimal amountPaid;
    private BigDecimal outstandingAmount;



}
