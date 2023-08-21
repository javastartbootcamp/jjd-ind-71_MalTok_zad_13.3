package pl.javastart.task;

import pl.javastart.task.product.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportReader {
    public List<Product> createProductsListFromFile(File file) throws FileNotFoundException {
        try (
                Scanner scanner = new Scanner(file)
        ) {
            List<Product> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(";");
                String name = splitedLine[0];
                BigDecimal price = new BigDecimal(splitedLine[1]);
                String currency = splitedLine[2];
                list.add(new Product(name, price, currency));
            }
            return list;
        }
    }

    public List<Currency> createCurrenciesListFromFile(File file) throws FileNotFoundException {
        try (
                Scanner scanner = new Scanner(file)
        ) {
            List<Currency> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(";");
                String currency = splitedLine[0];
                BigDecimal euroRate = new BigDecimal(splitedLine[1]);
                list.add(new Currency(currency, euroRate));
            }
            return list;
        }
    }

}
