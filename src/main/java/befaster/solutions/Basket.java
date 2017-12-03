package befaster.solutions;

import java.util.LinkedHashMap;

public class Basket {
    private LinkedHashMap<Character, Integer> items = new LinkedHashMap();

    public void add(char sku) {
        Integer numberOfItem = 1;
        if (items.containsKey(sku)) {
            numberOfItem = items.get(sku);
        }
        this.items.put(sku, numberOfItem++);
    }

    public Integer quantityFor(char sku) {
        return this.items.get(sku);
    }
}