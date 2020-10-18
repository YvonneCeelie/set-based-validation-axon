package com.example.command.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface EmailRepository extends JpaRepository<EmailJpaEntity, String> {
    EmailJpaEntity findEmailJpaEntityByAccountId(UUID accountId);
}
