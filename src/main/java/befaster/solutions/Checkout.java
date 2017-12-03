package befaster.solutions;

import java.util.Map;

public class Checkout {
    public static Integer checkout(String skus) {
        String itemSku = "B";
        int itemPrice = 30;
        Map productList = new <String, Integer>();

        if (skus == itemSku) {

            return itemPrice;
        }
        if (skus == "C")
            return 20;
        if (skus == "D")
            return 15;
        if (skus == "A")
            return 50;
        return -1;
    }
}
