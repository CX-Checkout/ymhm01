package befaster.solutions;

import java.util.function.Function;

public class LineItem {
    final Character productSku;
    private int productPrice;
    int quantity;

    public LineItem(Character productSku, int productPrice, int quantity) {
        this.productSku = productSku;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        int totalBasketLineAmount = this.productPrice * this.quantity;

        totalBasketLineAmount = applyDiscount(totalBasketLineAmount, (quantity) -> (quantity >= 5), 5, 'A', 200);
        totalBasketLineAmount = applyDiscount(totalBasketLineAmount, (quantity) -> (quantity >= 3), 3, 'A', 130);
        totalBasketLineAmount = applyDiscount(totalBasketLineAmount, (quantity) -> (quantity >= 2), 2, 'K', 150);
        totalBasketLineAmount = applyDiscount(totalBasketLineAmount, (quantity) -> (quantity >= 2), 2, 'B', 45);
        totalBasketLineAmount = applyDiscount(totalBasketLineAmount, (quantity) -> (quantity >= 5), 5, 'P', 200);

        return totalBasketLineAmount;
    }

    private int applyDiscount(int totalBasketLineAmount, Function<Integer, Boolean> fn, int productAOffer2Threshold, char discountedProduct, int discountedAmount) {
        if (fn.apply(this.quantity) && productSku == discountedProduct) {
            this.quantity = quantity - productAOffer2Threshold;
            totalBasketLineAmount = discountedAmount + getTotalAmount();
        }
        return totalBasketLineAmount;
    }

    public void remove(int quantity) {
        this.quantity = quantity > this.quantity ? 0 : this.quantity - quantity;
    }
}
