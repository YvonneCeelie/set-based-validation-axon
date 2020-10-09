package com.example.command.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailJpaEntity, String> {
}
