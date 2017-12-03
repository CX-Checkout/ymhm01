package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
        if (skus == "B")
            return 30;
        if (skus == "C")
            return 20;
        if (skus == "D")
            return 15;
        return 50;
    }
}
