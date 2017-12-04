package befaster.solutions;

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
        totalBasketLineAmount = applyDiscount();
        int productAOfferThreshold = 3;
        if (quantity >= productAOfferThreshold && productSku == 'A') {
            this.quantity = quantity - productAOfferThreshold;
            totalBasketLineAmount = 130 + getTotalAmount();
        }
        int productKOfferThreshold = 2;
        if (quantity >= productKOfferThreshold && productSku == 'K') {
            this.quantity = quantity - productKOfferThreshold;
            totalBasketLineAmount = 150 + getTotalAmount();
        }
        int productBOfferThreshold = 2;
        if (quantity >= productBOfferThreshold && productSku == 'B') {
            this.quantity = quantity - productBOfferThreshold;
            totalBasketLineAmount = 45 + getTotalAmount();
        }
        return totalBasketLineAmount;
    }

    private int applyDiscount() {
        int totalBasketLineAmount = 0;
        int productAOffer2Threshold = 5;
        if (quantity >= productAOffer2Threshold && productSku == 'A') {
            this.quantity = quantity - productAOffer2Threshold;
            totalBasketLineAmount = 200 + getTotalAmount();
        }
        return totalBasketLineAmount;
    }

    public void remove(int quantity) {
        this.quantity = quantity > this.quantity ? 0 : this.quantity - quantity;
    }
}
