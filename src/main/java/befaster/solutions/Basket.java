package befaster.solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Basket {
    LinkedHashMap<Character, Integer> items = new LinkedHashMap();
    private LineItem[] lineItems;

    static Basket getBasketWith(char[] listOfSkus) {
        Basket basket = new Basket();
        for (char sku : listOfSkus) {
            basket.add(sku);
        }
        return basket;
    }

    public Integer getBasketAmount(HashMap<Character, Integer> productList) {
        Integer price = 0;
        for (LineItem lineItem : lineItems) {
            price += lineItem.getTotalAmount();
        }
        /*for (Map.Entry<Character, Integer> item : items.entrySet()) {
            Character product = item.getKey();
            Integer productPrice = productList.get(product);
            Integer quantity = item.getValue();
            LineItem lineItem = new LineItem(product, productPrice, quantity);
            price += lineItem.getTotalAmount();
        }*/
        return price;
    }

    private void add(char sku) {
        Integer numberOfItem = 1;
        if (items.containsKey(sku)) {
            numberOfItem = items.get(sku) + 1;
        }
        this.items.put(sku, numberOfItem);
    }

}
