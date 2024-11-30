package com.talkytech.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
@NoArgsConstructor @AllArgsConstructor
public class LoanDTO {

    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    private String loanNumber;

    @NotEmpty(message = "LoanType can not be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000.00"
    )
    private BigDecimal totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000.00"
    )
    private BigDecimal amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000.00"
    )
    private BigDecimal outstandingAmount;
}
