package befaster.solutions;

import java.util.HashMap;

public class Checkout {

    private static HashMap<String, Integer> productList = initializeCatalogue();

    private static HashMap initializeCatalogue() {
        HashMap map = new HashMap<String, Integer>();
        map.put("A", 50);
        map.put("B", 30);
        map.put("C", 20);
        map.put("D", 15);
        return map;
    }

    public static Integer checkout(String skus) {
        Integer price = -1;
        if(skus == "AB") {
            price = 0;
            for (char sku : skus.toCharArray()) {
                price = price + productList.get(sku);
            }
        }
        if (productList.containsKey(skus))
            price = productList.get(skus);
        return price;
    }
}
