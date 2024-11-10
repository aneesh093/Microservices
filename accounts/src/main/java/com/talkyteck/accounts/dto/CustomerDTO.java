package com.talkyteck.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private String email;
    private String mobileNumber;

    private AccountsDTO accounts;
}
