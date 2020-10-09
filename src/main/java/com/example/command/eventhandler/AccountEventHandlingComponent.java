package com.example.command.eventhandler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.command.api.AccountCreatedEvent;
import com.example.command.persistence.EmailJpaEntity;
import com.example.command.persistence.EmailRepository;

@Component
@ProcessingGroup("accountEntity")
public class AccountEventHandlingComponent {

    private EmailRepository emailRepository;

    public AccountEventHandlingComponent(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @EventHandler
    public void on (AccountCreatedEvent event){
        emailRepository.save(new EmailJpaEntity(event.getEmailAddress()));
    }
}
