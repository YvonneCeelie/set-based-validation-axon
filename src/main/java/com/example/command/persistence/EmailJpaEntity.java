package com.example.command.persistence;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmailJpaEntity {
    @Id
    public String emailAddress;

    public UUID accountId;

    public EmailJpaEntity(){};

    public EmailJpaEntity(String emailAddress, UUID accountId) {
        this.emailAddress = emailAddress;
        this.accountId = accountId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailJpaEntity that = (EmailJpaEntity) o;
        return Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, accountId);
    }
}
