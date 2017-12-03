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

    public Integer getBasketAmount(HashMap<Character, Integer> productList) {
        Integer price = 0;
        for (Map.Entry<Character, Integer> item : items.entrySet()) {
            Character product = item.getKey();
            price += getAmountFor(productList, item, product);
        }
        return price;
    }

    private int getAmountFor(HashMap<Character, Integer> productList, Map.Entry<Character, Integer> item, Character product) {
        Integer productPrice = productList.get(product);
        Integer quantity = item.getValue();
        if(quantity == 3 && product == 'A'){
            return 130;
        }
        if(quantity == 2 && product == 'B'){
            return 45;
        }
        return productPrice * quantity;
    }

    public void add(char sku) {
        Integer numberOfItem = 1;
        if (items.containsKey(sku)) {
            numberOfItem = items.get(sku);
        }
        this.items.put(sku, numberOfItem++);
    }

}
