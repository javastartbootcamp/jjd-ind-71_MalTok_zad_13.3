package pl.javastart.task;

import pl.javastart.task.product.ProductEuroPrice;
import pl.javastart.task.product.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String productListFilePath = "src/main/resources/products.csv";
        File productListFile = new File(productListFilePath);

        String currencyListFilePath = "src/main/resources/currencies.csv";
        File currencyListFile = new File(currencyListFilePath);
        try {
            ImportReader importReader = new ImportReader();
            List<Product> productsList = importReader.createProductsListFromFile(productListFile);
            List<Currency> currencyList = importReader.createCurrenciesListFromFile(currencyListFile);

            if (!productsList.isEmpty() && !currencyList.isEmpty()) {
                ImportCalculator importCalc = new ImportCalculator(productsList, currencyList);

                BigDecimal totalEuroPrice = importCalc.countTotalEuroPrice();
                System.out.println("Suma wszystkich produktów w EUR: " + totalEuroPrice);

                BigDecimal averageEuroPrice = importCalc.countAverageEuroPrice(productsList);
                System.out.println("Średnia wartość produktu w EUR: " + averageEuroPrice);

                BigDecimal maxEuroPrice = importCalc.findMaxEuroPrice();
                ProductEuroPrice mostExpensiveProduct = importCalc.findProductByEuroPrice(maxEuroPrice);
                System.out.printf("Najdroższy produkt to: %s", mostExpensiveProduct);

                BigDecimal minEuroPrice = importCalc.findMinEuroPrice();
                ProductEuroPrice leastExpensiveProduct = importCalc.findProductByEuroPrice(minEuroPrice);
                System.out.printf("Najtańszy produkt to: %s", leastExpensiveProduct);
            } else {
                System.out.println("Lista jest pusta, nie można przetworzyć danych");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        }

    }
}
