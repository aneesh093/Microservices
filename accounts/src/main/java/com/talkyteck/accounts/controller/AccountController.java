package com.talkyteck.accounts.controller;

import com.talkyteck.accounts.constants.AccountConstants;
import com.talkyteck.accounts.dto.ErrorResponseDTO;
import com.talkyteck.accounts.dto.ResponseDTO;
import com.talkyteck.accounts.entity.Accounts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

@RestController
@RequestMapping(path="/api/")
public class AccountController {


    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody Accounts accounts) {
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }
}
