package com.patterns.strategy;

public class MarketContext {
    private int amount;

    public MarketContext(int amount) {
        this.amount = amount;
    }

    public void pay(Payment payment) {
        payment.pay(amount);
    }
}
