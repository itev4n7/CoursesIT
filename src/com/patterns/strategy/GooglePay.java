package com.patterns.strategy;

public class GooglePay implements Payment {
    private String email;
    private String password;
    private final CreditCard card = new CreditCard("974546", "14/7", "77", 10000);

    public GooglePay(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(long amount) {
        System.out.println("Pay by GooglePay: " + amount);
        card.transfer(amount);
    }
}
