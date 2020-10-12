package com.example.command.handler;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import com.example.command.api.ChangeEmailAddressCommand;
import com.example.command.api.RequestEmailChangeCommand;
import com.example.command.persistence.EmailRepository;

@Component
public class AccountCommandHandler {

    @CommandHandler
public void handle(RequestEmailChangeCommand command, CommandGateway commandGateway, EmailRepository emailRepository){
        if (emailRepository.existsById(command.getUpdatedEmailAddress())){
            throw new IllegalStateException(String.format("Account with email address %s already exists",
                                            command.getUpdatedEmailAddress()));
        }
        commandGateway.send(new ChangeEmailAddressCommand(command.getAccountId(), command.getUpdatedEmailAddress()));
    }
}
