package pl.javastart.task.product;

import java.math.BigDecimal;

public class ProductEuroPrice {
    private Product product;
    private BigDecimal euroPrice;

    public ProductEuroPrice(Product product, BigDecimal euroPrice) {
        this.product = product;
        this.euroPrice = euroPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(BigDecimal euroPrice) {
        this.euroPrice = euroPrice;
    }

    @Override
    public String toString() {
        return product.getName() + ", cena " + euroPrice + " EUR\n";
    }
}
