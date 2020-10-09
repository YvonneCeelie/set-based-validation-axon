package com.example.command.api;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequestData {
    private String emailAddress;

    public AccountRequestData(){};
    public AccountRequestData(String emailAddress) {
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
        AccountRequestData that = (AccountRequestData) o;
        return Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}
