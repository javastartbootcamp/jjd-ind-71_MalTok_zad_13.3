package pl.javastart.task;

import java.math.BigDecimal;

public class Currency {
    private String currency;
    private BigDecimal euroRate;

    public Currency(String currency, BigDecimal euroRate) {
        this.currency = currency;
        this.euroRate = euroRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getEuroRate() {
        return euroRate;
    }

    public void setEuroRate(BigDecimal euroRate) {
        this.euroRate = euroRate;
    }

    @Override
    public String toString() {
        return currency + ", price for 1 EURO: " + euroRate;
    }
}
