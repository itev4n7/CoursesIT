package com.patterns.strategy;

public class CreditCard {
    private String cardNum;
    private String date;
    private String cvv;
    private int money;

    public CreditCard(String cardNum, String date, String cvv, int money) {
        this.cardNum = cardNum;
        this.date = date;
        this.cvv = cvv;
        this.money = money;
    }

    public void replenishment(int amount) {
        this.money += amount;
    }

    public void transfer(long amount) {
        this.money -= amount;
    }
}
