package com.talkyteck.accounts.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = "Account number cannot be null")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account number is not valid")
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be null")
    private String accountType;

    @NotEmpty(message = "Branch address cannot be null")
    private String branchAddress;
}
