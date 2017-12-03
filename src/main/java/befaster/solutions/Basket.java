package befaster.solutions;

import java.util.*;

public class Basket {
    LinkedHashMap<Character, Integer> items = new LinkedHashMap();
    private List<LineItem> lineItems = new ArrayList;

    static Basket getBasketWith(char[] listOfSkus, HashMap<Character, Integer> productList) {
        Basket basket = new Basket();
        for (char sku : listOfSkus) {
            basket.add(sku);
        }
        for (Map.Entry<Character, Integer> item : basket.items.entrySet()) {
            Character product = item.getKey();
            Integer productPrice = productList.get(product);
            Integer quantity = item.getValue();
            LineItem lineItem = new LineItem(product, productPrice, quantity);
            basket.lineItems.add(lineItem);
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
