package com.example.command.handler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.command.api.AccountCreatedEvent;
import com.example.command.api.EmailAddressChangedEvent;
import com.example.command.persistence.EmailJpaEntity;
import com.example.command.persistence.EmailRepository;

@Component
@ProcessingGroup("emailEntity")
public class AccountEventHandler {

    @EventHandler
    public void on (AccountCreatedEvent event, EmailRepository emailRepository){
        emailRepository.save(new EmailJpaEntity(event.getEmailAddress(), event.getAccountId()));
    }

    @EventHandler
    public void on (EmailAddressChangedEvent event, EmailRepository emailRepository){
        // Delete the former email address to make it possible to use that one again
        emailRepository.delete(emailRepository.findEmailJpaEntityByAccountId(event.getAccountId()));
        emailRepository.save(new EmailJpaEntity(event.getEmailAddress(), event.getAccountId()));
    }

}
