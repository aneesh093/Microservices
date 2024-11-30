package com.talkytech.loans.service;

import com.talkytech.loans.dto.LoanDTO;

public interface ILoanService {

    void createLoan(String mobileNumber);
    LoanDTO fetchLoan(String mobileNumber);

    boolean updateLoan(LoanDTO loanDTO);

    boolean deleteLoan(String mobileNumber);
}
