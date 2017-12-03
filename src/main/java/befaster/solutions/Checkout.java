package befaster.solutions;

import java.util.HashMap;

public class Checkout {

    private static HashMap<Character, Integer> productList = initializeCatalogue();

    static HashMap initializeCatalogue() {
        HashMap map = new HashMap<String, Integer>();
        map.put('A', 50);
        map.put('B', 30);
        map.put('C', 20);
        map.put('D', 15);
        map.put('E', 40);
        map.put('F', 10);
        return map;
    }

    public static Integer checkout(String skus) {
        Integer price;
        try {
            Basket basket = Basket.getBasketWith(skus.toCharArray(), productList);
            price = basket.getBasketAmount();
        } catch (NullPointerException ex) {
            price = -1;
        }
        return price;
    }

}
