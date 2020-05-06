package com.patterns.strategy;

public class PayCard implements Payment {
    private final CreditCard card;

    public PayCard(CreditCard card) {
        this.card = card;
    }

    @Override
    public void pay(long amount) {
        System.out.println("Pay by card: " + amount);
        card.transfer(amount);
    }
}
