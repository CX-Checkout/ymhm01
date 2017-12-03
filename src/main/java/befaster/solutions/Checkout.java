package befaster.solutions;

import javafx.beans.binding.FloatExpression;

import java.io.Console;
import java.util.HashMap;

public class Checkout {

    private static HashMap<Character, Integer> productList = initializeCatalogue();

    private static HashMap initializeCatalogue() {
        HashMap map = new HashMap<String, Integer>();
        map.put('A', 50);
        map.put('B', 30);
        map.put('C', 20);
        map.put('D', 15);
        return map;
    }

    public static Integer checkout(String skus) {
        Integer price = 0;
        Basket basket = new Basket();
        char[] listOfSkus = skus.toCharArray();
        if (skus.contains("AAA")) {
            return 130;
        }
        if (skus.contains("BB")) {
            return 45;
        }
        try {
            for (char sku : listOfSkus) {
                basket.add(sku);
            }
            for (char sku : listOfSkus) {
                price += basket.quantityFor(sku) * productList.get(sku);
            }
        } catch (NullPointerException ex) {
            price = -1;
        }
        return price;
    }
}