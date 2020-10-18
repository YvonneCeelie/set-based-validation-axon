package com.example.command.resolver;

import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;

import org.axonframework.messaging.Message;
import org.axonframework.messaging.annotation.ParameterResolver;
import org.axonframework.messaging.annotation.ParameterResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.command.api.ChangeEmailAddressCommand;
import com.example.command.persistence.EmailRepository;

@Component
public class EmailAlreadyExistsResolverFactory implements ParameterResolver<Boolean> ,ParameterResolverFactory {

    private EmailRepository emailRepository;

    @Autowired
    public EmailAlreadyExistsResolverFactory(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public ParameterResolver<?> createInstance(Executable executable, Parameter[] parameters, int parameterIndex) {
        if (Boolean.class.equals(parameters[parameterIndex].getType())) {
            return this;
        }
        return null;
    }

    @Override
    public Boolean resolveParameterValue(Message<?> message) {
        if (matches(message)) {
            String emailAddress = ((ChangeEmailAddressCommand) message.getPayload()).getEmailAddress();
            return emailRepository.findById(emailAddress).isPresent();
        }
        throw new IllegalArgumentException("Message payload not of type ChangeEmailAddressCommand");    }


    @Override
    public boolean matches(Message<?> message) {
        return ChangeEmailAddressCommand.class.isAssignableFrom(message.getPayloadType());
    }

    @Override
    public Class<?> supportedPayloadType() {
        return ChangeEmailAddressCommand.class;
    }
}
