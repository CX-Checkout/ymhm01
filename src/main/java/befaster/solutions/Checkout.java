package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
        if (skus == "B")
            return 30;
        if (skus == "C")
            return 20;
        if (skus == "D")
            return 15;
        if (skus == "A")
            return 50;
        return -1;
    }
}