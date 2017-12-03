package befaster.solutions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

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

    public Integer getBasketAmount() {
        Integer price = 0;
        applyCrossItemDiscount('E', 'B', 2, (quantity) -> (quantity >= 2));
        applyCrossItemDiscount('F', 'F', 2, (quantity) -> (quantity > 2));
        for (LineItem lineItem : lineItems) {
            price += lineItem.getTotalAmount();
        }
        return price;
    }

    private void applyCrossItemDiscount(char skuInitiatingDiscount, char discountedItem, int discountThreshold, Function<Integer, Boolean> fn) {
        Stream<LineItem> lineItemStream = this.lineItems.stream();
        Optional<LineItem> productELineItem = lineItemStream.filter(item -> item.productSku == skuInitiatingDiscount).findFirst();
        Integer productEQuantity = productELineItem.map(item -> item.quantity).orElse(0);

        if (productELineItem != null && fn.apply(productEQuantity)) {
            LineItem productBLineItem = this.lineItems.stream().filter(item -> item.productSku == discountedItem).findFirst().orElse(null);
            if (productBLineItem != null) {
                this.lineItems.remove(productBLineItem);
                int numberOfItemForFree = (int) Math.floor((double) productEQuantity / discountThreshold);
                productBLineItem.remove(numberOfItemForFree);
                this.lineItems.add(productBLineItem);
            }
        }
    }

}
