package com.talkytech.loans.mapper;

import com.talkytech.loans.dto.LoanDTO;
import com.talkytech.loans.entity.Loans;

public class LoanMapper {

    public static Loans mapToLoans(LoanDTO loanDTO, Loans loans){
        loans.setLoanNumber(loanDTO.getLoanNumber());
        loans.setLoanType(loanDTO.getLoanType());
        loans.setTotalLoan(loanDTO.getTotalLoan());
        loans.setAmountPaid(loanDTO.getAmountPaid());
        loans.setMobileNumber(loanDTO.getMobileNumber());
        loans.setOutstandingAmount(loanDTO.getOutstandingAmount());

        return loans;
    }

    public static LoanDTO mapToLoanDTO(LoanDTO loanDTO, Loans loans){
        loanDTO.setLoanNumber(loans.getLoanNumber());
        loanDTO.setLoanType(loans.getLoanType());
        loanDTO.setTotalLoan(loans.getTotalLoan());
        loanDTO.setAmountPaid(loans.getAmountPaid());
        loanDTO.setMobileNumber(loans.getMobileNumber());
        loanDTO.setOutstandingAmount(loans.getOutstandingAmount());

        return loanDTO;
    }
}
