package befaster.solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Basket {
    private LinkedHashMap<Character, Integer> items = new LinkedHashMap();

    static Basket getBasketWith(char[] listOfSkus) {
        Basket basket = new Basket();
        for (char sku : listOfSkus) {
            basket.add(sku);
        }
        return basket;
    }

    static Integer getBasketAmount(Integer price, Basket basket, char[] listOfSkus, HashMap<Character, Integer> productList) {
        for (char sku : listOfSkus) {
            price += basket.quantityFor(sku) * productList.get(sku);
        }
        return price;
    }

    public void add(char sku) {
        Integer numberOfItem = 1;
        if (items.containsKey(sku)) {
            numberOfItem = items.get(sku);
        }
        this.items.put(sku, numberOfItem++);
    }

    public Integer quantityFor(char sku) {
        return this.items.get(sku);
    }
}
