package befaster.solutions;

import java.util.*;
import java.util.stream.Stream;

public class Basket {
    private List<LineItem> lineItems = new ArrayList<>();
    private final int ONE = 1;

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

    public Integer getBasketAmount() {
        Integer price = 0;
        applyCrossItemDiscount();
        for (LineItem lineItem : lineItems) {
            price += lineItem.getTotalAmount();
        }
        return price;
    }

    private void applyCrossItemDiscount() {
        Stream<LineItem> lineItemStream = this.lineItems.stream();
        Optional<LineItem> productELineItem = lineItemStream.filter(item -> item.productSku == 'E').findFirst();
        Integer productEQuantity = productELineItem.map(item -> item.quantity).orElse(0);
        if (productELineItem != null && productEQuantity >= 2) {
            LineItem productBLineItem = this.lineItems.stream().filter(item -> item.productSku == 'B').findFirst().orElse(null);
            if (productBLineItem != null) {
                this.lineItems.remove(productBLineItem);
                int numberOfItemForFree =(int) Math.ceil((double)productEQuantity / 2);
                productBLineItem.remove(numberOfItemForFree);
                this.lineItems.add(productBLineItem);
            }
        }
    }

}
