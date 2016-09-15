package com.si.domain;

/**
 * Created by Saranda Ilazi on 06/09/2016.
 */
public class Account {
    private int id;
    private int accountNumber;
    private AccountType accountType;
    private double amount;

    public Account() {
    }

    public Account(int id, int accountNumber, AccountType accountType, double amount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        return accountNumber == account.accountNumber;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", pinCode=" + pinCode +
                ", accountType=" + accountType +
                '}';
    }

}
