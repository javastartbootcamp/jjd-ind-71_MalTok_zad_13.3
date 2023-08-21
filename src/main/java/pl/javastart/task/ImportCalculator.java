package pl.javastart.task;

import pl.javastart.task.product.ProductEuroPrice;
import pl.javastart.task.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ImportCalculator {
    private final List<ProductEuroPrice> euroPriceList;

    public ImportCalculator() {
        this.euroPriceList = new ArrayList<>();
    }

    public void fillEuroPriceList(List<Product> list, List<Currency> currencyList) {
        for (Product product : list) {
            BigDecimal euroPrice = countEuroPrice(product, currencyList);
            euroPriceList.add(new ProductEuroPrice(product, euroPrice));
        }
    }

    private BigDecimal countEuroPrice(Product product, List<Currency> list) {
        BigDecimal euroPrice = BigDecimal.ZERO;
        for (Currency currency : list) {
            if (currency.getCurrency().equals(product.getCurrency())) {
                euroPrice = product.getPrice().divide(currency.getEuroRate(), RoundingMode.HALF_UP);
            }
        }
        return euroPrice;
    }

    public BigDecimal countTotalEuroPrice() {
        BigDecimal totalEuroSum = BigDecimal.ZERO;
        for (ProductEuroPrice productEuroPrice : euroPriceList) {
            totalEuroSum = totalEuroSum.add(productEuroPrice.getEuroPrice());
        }
        return totalEuroSum;
    }

    public BigDecimal countAverageEuroPrice(List<Product> list) {
        return countTotalEuroPrice().divide(BigDecimal.valueOf(list.size()), RoundingMode.HALF_UP);
    }

    public BigDecimal findMaxEuroPrice() {
        ProductEuroPrice mostExpensiveProduct = euroPriceList.get(0);
        BigDecimal maxEuroPrice = mostExpensiveProduct.getEuroPrice();
        for (ProductEuroPrice productEuroPrice : euroPriceList) {
            maxEuroPrice = productEuroPrice.getEuroPrice().max(maxEuroPrice);
        }
        return maxEuroPrice;
    }

    public BigDecimal findMinEuroPrice() {
        ProductEuroPrice leastExpensiveProduct = euroPriceList.get(0);
        BigDecimal minEuroPrice = leastExpensiveProduct.getEuroPrice();
        for (ProductEuroPrice productEuroPrice : euroPriceList) {
            minEuroPrice = productEuroPrice.getEuroPrice().min(minEuroPrice);
        }
        return minEuroPrice;
    }

    public ProductEuroPrice findProductByEuroPrice(BigDecimal price) {
        ProductEuroPrice foundProductPair = null;
        for (ProductEuroPrice productEuroPrice : euroPriceList) {
            if (productEuroPrice.getEuroPrice().equals(price)) {
                foundProductPair = productEuroPrice;
            }
        }
        return foundProductPair;
    }
}

