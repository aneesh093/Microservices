package com.talkyteck.accounts.repository;

import com.talkyteck.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

    public Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    @Query("delete from Accounts where customerId = ?1")
    void deleteByCustomerId(Long customerId);
}
