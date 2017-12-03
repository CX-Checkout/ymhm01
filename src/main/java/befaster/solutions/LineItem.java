package befaster.solutions;

public class LineItem {
    private final Character productSku;
    private int productPrice;
    private int quantity;

    public LineItem(Character productSku, int productPrice, int quantity) {
        this.productSku = productSku;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        int totalBasketLineAmount = this.productPrice * this.quantity;
        int productAOffer2Threshold = 5;
        if(quantity >= productAOffer2Threshold && productSku == 'A'){
            this.quantity = quantity - productAOffer2Threshold;
            totalBasketLineAmount = 200 + getTotalAmount();
        }
        int productAOfferThreshold = 3;
        if(quantity >= productAOfferThreshold && productSku == 'A'){
            this.quantity = quantity - productAOfferThreshold;
            totalBasketLineAmount = 130 + getTotalAmount();
        }
        int productBOfferThreshold = 2;
        if(quantity >= productBOfferThreshold && productSku == 'B'){
            this.quantity = quantity - productBOfferThreshold;
            totalBasketLineAmount = 45 + getTotalAmount();
        }
        return totalBasketLineAmount;
    }
}