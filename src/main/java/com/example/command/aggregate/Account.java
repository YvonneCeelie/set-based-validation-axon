package com.example.command.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.command.api.AccountCreatedEvent;
import com.example.command.api.CreateAccountCommand;

@Aggregate
public class Account {
    @AggregateIdentifier
    public UUID accountId;

    Account(){}

    @CommandHandler
    Account(CreateAccountCommand command){
        AggregateLifecycle.apply(new AccountCreatedEvent(command.getAccountId(), command.getEmailAddress()));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accountId = event.getAccountId();
    }
}
