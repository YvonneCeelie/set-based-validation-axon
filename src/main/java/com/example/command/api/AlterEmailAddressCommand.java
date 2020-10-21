package com.example.command.api;

import java.util.Objects;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AlterEmailAddressCommand {
    @TargetAggregateIdentifier
    private UUID accountId;
    private String updatedEmailAddress;

    public AlterEmailAddressCommand(UUID accountId, String emailAddress) {
        this.accountId = accountId;
        this.updatedEmailAddress = emailAddress;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getEmailAddress() {
        return updatedEmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.updatedEmailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlterEmailAddressCommand that = (AlterEmailAddressCommand) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(updatedEmailAddress, that.updatedEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, updatedEmailAddress);
    }
}
