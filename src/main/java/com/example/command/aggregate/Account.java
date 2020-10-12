package com.example.command.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.command.api.AccountCreatedEvent;
import com.example.command.api.EmailAddressChangedEvent;
import com.example.command.api.ChangeEmailAddressCommand;
import com.example.command.api.CreateAccountCommand;

@Aggregate
public class Account {
    @AggregateIdentifier
    private UUID accountId;

    private String emailAddress;

    Account(){}

    @CommandHandler
    public Account(CreateAccountCommand command){
        AggregateLifecycle.apply(new AccountCreatedEvent(command.getAccountId(), command.getEmailAddress()));
    }

    @CommandHandler
    public void handle(ChangeEmailAddressCommand command){
        if (!this.emailAddress.equals(command.getEmailAddress())) {
            AggregateLifecycle.apply(new EmailAddressChangedEvent(command.getAccountId(), command.getEmailAddress()));
        }
    }


    @EventSourcingHandler
    public void on (AccountCreatedEvent event){
        this.accountId = event.getAccountId();
        this.emailAddress = event.getEmailAddress();
    }

    @EventSourcingHandler
    public void on(EmailAddressChangedEvent event){
        this.emailAddress = event.getEmailAddress();
    }

}
