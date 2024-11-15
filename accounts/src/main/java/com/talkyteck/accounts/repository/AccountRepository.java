package com.talkyteck.accounts.repository;

import com.talkyteck.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

    public Optional<Accounts> findByCustomerId(Long customerId);
}
