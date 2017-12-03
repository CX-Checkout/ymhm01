package befaster.solutions;

import java.util.*;

public class Basket {
    private List<LineItem> lineItems = new ArrayList<>();

    static Basket getBasketWith(char[] listOfSkus, HashMap<Character, Integer> productList) {
        Basket basket = new Basket();
        LinkedHashMap<Character, Integer> items = GroupByQuantity(listOfSkus);
        addItemsToBasket(productList, basket, items);
        return basket;
    }

    private static void addItemsToBasket(HashMap<Character, Integer> productList, Basket basket, LinkedHashMap<Character, Integer> items) {
        for (Map.Entry<Character, Integer> item : items.entrySet()) {
            Character product = item.getKey();
            Integer productPrice = productList.get(product);
            Integer quantity = item.getValue();
            LineItem lineItem = new LineItem(product, productPrice, quantity);
            basket.lineItems.add(lineItem);
        }
    }

    private static LinkedHashMap<Character, Integer> GroupByQuantity(char[] listOfSkus) {
        LinkedHashMap<Character, Integer> items = new LinkedHashMap();
        for (char sku : listOfSkus) {
            Integer numberOfItem = 1;
            if (items.containsKey(sku)) {
                numberOfItem = items.get(sku) + 1;
            }
            items.put(sku, numberOfItem);
        }
        return items;
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

}
