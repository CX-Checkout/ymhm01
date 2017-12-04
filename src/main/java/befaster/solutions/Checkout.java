package befaster.solutions;

import java.util.HashMap;

public class Checkout {

    private static HashMap<Character, Integer> productList = Catalogue.initializeCatalogue();

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
