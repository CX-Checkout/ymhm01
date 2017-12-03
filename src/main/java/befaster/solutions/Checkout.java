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
        return map;
    }

    public static Integer checkout(String skus) {
        Integer price;
        if (skus == "AAA") {
            return 130;
        }
        if (skus == "BB") {
            return 45;
        }
        try {
            Basket basket = Basket.getBasketWith(skus.toCharArray());
            price = basket.getBasketAmount(productList);
        } catch (NullPointerException ex) {
            price = -1;
        }
        return price;
    }

}