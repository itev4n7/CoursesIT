package com.patterns.builder;

public class BankAccount {
    private final long accountId;
    private final String owner;
    private final String branch;
    private final double balance;
    private final double interestRate;

    private BankAccount(Builder builder) {
        this.accountId = builder.accountId;
        this.owner = builder.owner;
        this.branch = builder.branch;
        this.balance = builder.balance;
        this.interestRate = builder.interestRate;
    }

    public static class Builder {
        private long accountId;
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder setId(long accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder setBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                  "accountId=" + accountId +
                  ", owner='" + owner + '\'' +
                  ", branch='" + branch + '\'' +
                  ", balance=" + balance +
                  ", interestRate=" + interestRate +
                  '}';
    }

    public long getAccountId() {
        return accountId;
    }

    public String getOwner() {
        return owner;
    }

    public String getBranch() {
        return branch;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
