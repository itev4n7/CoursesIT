package com.patterns.builder;

public class BuilderExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount.Builder()
                  .setId(1245)
                  .setOwner("Guru")
                  .setBranch("Health")
                  .setBalance(1200)
                  .setRate(1.9)
                  .build();

        System.out.println(account);
    }
}