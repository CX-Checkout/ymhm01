package befaster.solutions;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BasketTest {

    @Test
    public void adds_items_in_basket() {
        String items = "BBAAA";
        Integer amount = 175;
        HashMap<Character, Integer> productList = Checkout.initializeCatalogue();
        Basket basket = Basket.getBasketWith(items.toCharArray());
        Integer basketAmount = basket.getBasketAmount(productList);
        assertThat(basket.items.size(), equalTo(2));
        assertThat(basketAmount, equalTo(amount));
    }

}