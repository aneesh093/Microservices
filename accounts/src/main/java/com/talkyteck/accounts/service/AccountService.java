package com.talkyteck.accounts.service;

import com.talkyteck.accounts.constants.AccountConstants;
import com.talkyteck.accounts.dto.AccountsDTO;
import com.talkyteck.accounts.dto.CustomerDTO;
import com.talkyteck.accounts.entity.Accounts;
import com.talkyteck.accounts.entity.Customer;
import com.talkyteck.accounts.exceptions.CustomerAlreadyExistException;
import com.talkyteck.accounts.exceptions.ResourceNotFoundException;
import com.talkyteck.accounts.repository.AccountRepository;
import com.talkyteck.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository  customerRepository;
    private ModelMapper mapper;

    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = mapper.map(customerDTO, Customer.class);

        if(customerRepository.findByMobileNumber(customer.getMobileNumber()).isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exists "+customer.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Name");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(savedCustomer));
    }

    public Accounts createAccount(Customer savedCustomer) {
        Accounts account = new Accounts();
        account.setAccountNumber(100000L+ new Random().nextInt(900000));
        account.setCustomerId(savedCustomer.getCustomerId());
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Name");
        return account;
    }

    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer", "mobile number", mobileNumber)
        );

        Accounts account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()->new ResourceNotFoundException("Account", "customer id", String.valueOf(customer.getCustomerId()))
        );

        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        customerDTO.setAccounts(mapper.map(account, AccountsDTO.class));
        return customerDTO;
    }

    public boolean updateCustomer(CustomerDTO customerDTO) {
      boolean isUpdated = false;
      AccountsDTO accountsDTO= customerDTO.getAccounts();
      if(accountsDTO != null) {
          Accounts account = accountRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(
                  () -> new ResourceNotFoundException("Account", "account number", String.valueOf(accountsDTO.getAccountNumber()))
          );
          mapper.map(accountsDTO, account);
          account = accountRepository.save(account);

          long customerId = account.getCustomerId();
          Customer customer = customerRepository.findById(customerId).orElseThrow(
                  () -> new ResourceNotFoundException("Customer", "customer id", String.valueOf(customerId))
          );
          mapper.map(customerDTO, customer);
          customer = customerRepository.save(customer);
          isUpdated = true;
      }
      return isUpdated;
    }
}
