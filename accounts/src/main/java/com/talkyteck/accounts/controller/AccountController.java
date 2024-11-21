package com.talkyteck.accounts.controller;

import com.talkyteck.accounts.constants.AccountConstants;
import com.talkyteck.accounts.dto.CustomerDTO;
import com.talkyteck.accounts.dto.ResponseDTO;
import com.talkyteck.accounts.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Accounts CRUD API", description = "Accounts APIs for CRUD")
@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @Operation(
            summary = "Create a new customer",
            description = "This API is used to create a new customer"
    )
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customer) {
        accountService.createCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Get customer details",
            description = "This API is used to get customer details"
    )
    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerDTO> getCustomer(@RequestParam
                                                       @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number is not valid")
                                                       String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDTO);
    }

    @Operation(
            summary = "Update customer details",
            description = "This API is used to update customer details"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Updated"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")}
    )
    @PutMapping("/updateCustomer")
    public ResponseEntity<ResponseDTO> updateCustomer(@Valid @RequestBody CustomerDTO customer) {
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

@Operation(
        summary = "Delete customer details",
        description = "This API is used to delete customer details"
)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Deleted"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")}
)
    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<ResponseDTO> deleteCustomer(@RequestParam
                                                          @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number is not valid")
                                                          String mobileNumber) {
        boolean isDeleted = accountService.deleteCustomer(mobileNumber);
        if (isDeleted) {
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
