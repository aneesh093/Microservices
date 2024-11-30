package com.talkytech.loans.service;

import com.talkytech.loans.constants.LoansConstants;
import com.talkytech.loans.dto.LoanDTO;
import com.talkytech.loans.entity.Loans;
import com.talkytech.loans.exception.LoanAlreadyExistException;
import com.talkytech.loans.exception.ResourceNotFoundException;
import com.talkytech.loans.mapper.LoanMapper;
import com.talkytech.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    public LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans= loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistException("Loan already registered with given mobileNumber "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(BigDecimal.valueOf(0.0));
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDTO fetchLoan(String mobileNumber) {
        Loans loan = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "mobileNumber",mobileNumber )
        );
        return LoanMapper.mapToLoanDTO(new LoanDTO(), loan);
    }

    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        Loans loan = loansRepository.findByLoanNumber(loanDTO.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "LoanNumber",loanDTO.getMobileNumber())
        );
        LoanMapper.mapToLoans(loanDTO,loan);
        loansRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}
