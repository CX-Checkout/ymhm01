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
        map.put('G', 20);
        map.put('H', 10);
        map.put('I', 35);
        map.put('J', 60);
        map.put('K', 80);
        map.put('L', 90);
        map.put('M', 15);
        map.put('N', 40);
        map.put('O', 10);
        map.put('P', 50);
        map.put('Q', 30);
        map.put('R', 50);
        map.put('S', 30);
        map.put('T', 20);
        map.put('U', 40);
        map.put('V', 50);
        map.put('W', 20);
        map.put('X', 90);
        map.put('Y', 10);
        map.put('Z', 50);
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
