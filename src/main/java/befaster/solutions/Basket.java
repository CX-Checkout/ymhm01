package befaster.solutions;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
        LinkedHashMap<Character, Integer> items = new LinkedHashMap();

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
            Integer productPrice = productList.get(product);
            Integer quantity = item.getValue();
            LineItem lineItem = new LineItem(product, productPrice1, quantity);
            price += lineItem.getTotalAmount();
            /*price += getAmountFor(productList, item, product);*/
        }
        return price;
    }

    private int getAmountFor(HashMap<Character, Integer> productList, Map.Entry<Character, Integer> item, Character product) {
        Integer productPrice = productList.get(product);
        Integer quantity = item.getValue();
        int totalBasketLineAmount = productPrice * quantity;
        if(quantity >= 3 && product == 'A'){
            int remainingQuantity = quantity - 3;
            totalBasketLineAmount = 130 + getAmountFor(productList, new  AbstractMap.SimpleEntry(product, remainingQuantity), product);
        }
        if(quantity >= 2 && product == 'B'){
            totalBasketLineAmount = 45 + getAmountFor(productList, new  AbstractMap.SimpleEntry(product, quantity - 2), product);
        }
        return totalBasketLineAmount;
    }

    private void add(char sku) {
        Integer numberOfItem = 1;
        if (items.containsKey(sku)) {
            numberOfItem = items.get(sku) + 1;
        }
        this.items.put(sku, numberOfItem);
    }

}
