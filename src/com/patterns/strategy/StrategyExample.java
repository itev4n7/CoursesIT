package com.patterns.strategy;

public class StrategyExample {
    public static void main(String[] args) {
        CreditCard card = new CreditCard("987", "14/9", "99", 1587);
        MarketContext marketContext = new MarketContext(1000);

        Payment payment1 = new PayCard(card);
        Payment payment2 = new GooglePay("qwerty@gmail.com", "qwerty");

        marketContext.pay(payment1);
        marketContext.pay(payment2);

    }
}
