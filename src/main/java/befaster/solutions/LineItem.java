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
        int offerTreshold = 3;
        if(quantity >= offerTreshold && productSku == 'A'){
            this.quantity = quantity - offerTreshold;
            totalBasketLineAmount = 130 + getTotalAmount();
        }
        if(quantity >= 2 && productSku == 'B'){
            this.quantity = quantity - 2;
            totalBasketLineAmount = 45 + getTotalAmount();
        }
        return totalBasketLineAmount;
    }
}
