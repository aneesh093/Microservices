package com.talkyteck.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Name cannot be null")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Mobile number cannot be null")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number is not valid")
    private String mobileNumber;

    private AccountsDTO accounts;
}
