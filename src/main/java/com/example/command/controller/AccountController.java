package com.example.command.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.command.api.AccountRequestData;
import com.example.command.api.CreateAccountCommand;

@RestController
public class AccountController {
    private CommandGateway commandGateway;

    public AccountController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }



    @PostMapping(path = "/accounts")
    public CompletableFuture<Void> register(@RequestBody AccountRequestData accountRequestData) {
        UUID accountId = UUID.randomUUID();
        return  commandGateway.send(new CreateAccountCommand(accountId, accountRequestData.getEmailAddress()));
    }
}
