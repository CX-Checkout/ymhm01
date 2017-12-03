package befaster.solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private LinkedHashMap<Character, Integer> items = new LinkedHashMap();

    static Basket getBasketWith(char[] listOfSkus) {
        Basket basket = new Basket();
        for (char sku : listOfSkus) {
            basket.add(sku);
        }
        return basket;
    }

    public Integer getBasketAmount(char[] listOfSkus, HashMap<Character, Integer> productList) {
        Integer price = 0;
        for (Map.Entry<Character, Integer> item:items.entrySet()) {
            price += item.getKey() * item.getValue();
        }
/*        for (char sku : listOfSkus) {
            price += quantityFor(sku) * productList.get(sku);
        }*/
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
