package com.example.command.persistence;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmailJpaEntity {
    @Id
    public String emailAddress;

    public EmailJpaEntity(){};

    public EmailJpaEntity(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailJpaEntity that = (EmailJpaEntity) o;
        return Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

}
