package com.example.command.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.config.Configurer;
import org.axonframework.modelling.command.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.command.aggregate.Account;
import com.example.command.interceptor.AccountCreationDispatchInterceptor;

@Configuration
public class AxonConfig {
    @Bean
    public CommandGateway commandGateway(CommandBus commandBus,
                                         AccountCreationDispatchInterceptor accountCreationDispatchInterceptor) {
        return DefaultCommandGateway.builder()
                                    .commandBus(commandBus)
                                    .dispatchInterceptors(accountCreationDispatchInterceptor)
                                    .build();
    }
}
