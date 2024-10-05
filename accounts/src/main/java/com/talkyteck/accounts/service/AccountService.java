package com.talkyteck.accounts.service;

import com.talkyteck.accounts.dto.AccountsDTO;
import com.talkyteck.accounts.entity.Accounts;
import com.talkyteck.accounts.repository.AccountRepository;
import com.talkyteck.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository  customerRepository;
    private ModelMapper mapper;

    public void createAccount(AccountsDTO accountsDTO) {
        Accounts accounts = mapper.map(accountsDTO, Accounts.class);
        accountRepository.save(accounts);

    }
}
