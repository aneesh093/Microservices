package com.talkyteck.accounts.controller;

import com.talkyteck.accounts.constants.AccountConstants;
import com.talkyteck.accounts.dto.CustomerDTO;
import com.talkyteck.accounts.dto.ResponseDTO;
import com.talkyteck.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customer) {
        accountService.createCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerDTO> getCustomer(@RequestParam String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDTO);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<ResponseDTO> updateCustomer(@RequestBody CustomerDTO customer) {
        boolean isUpdated = accountService.updateCustomer(customer);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }
}
