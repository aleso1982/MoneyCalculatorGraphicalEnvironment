package moneycalculator.model;

public class Money {
    
    private final Number amount;
    //private final double amount;
    private final Currency currency;

    public Money(Number amount, Currency currency) {
    //public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Number getAmount() {
    //public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency=" + currency + '}';
    }

}
