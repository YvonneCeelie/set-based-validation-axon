package com.example.command.api;

import java.util.Objects;
import java.util.UUID;

import org.axonframework.commandhandling.RoutingKey;

public class RequestEmailChangeCommand {
    @RoutingKey
    private UUID accountId;
    private String updatedEmailAddress;

    public RequestEmailChangeCommand(UUID accountId, String emailAddress) {
        this.accountId = accountId;
        this.updatedEmailAddress = emailAddress;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getUpdatedEmailAddress() {
        return updatedEmailAddress;
    }

    public void setUpdatedEmailAddress(String updatedEmailAddress) {
        this.updatedEmailAddress = updatedEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEmailChangeCommand that = (RequestEmailChangeCommand) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(updatedEmailAddress, that.updatedEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, updatedEmailAddress);
    }
}
