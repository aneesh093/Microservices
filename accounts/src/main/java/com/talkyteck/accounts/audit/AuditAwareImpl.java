package com.talkyteck.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS");
    }
}
