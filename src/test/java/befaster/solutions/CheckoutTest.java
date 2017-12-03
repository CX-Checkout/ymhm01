package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutTest {

    @Test
    public void checkout_return_item_A_price_for_item_A_in_basket() {
        String itemA = "A";
        Integer itemAPrice = 50;
        assertThat(Checkout.checkout(itemA), equalTo(itemAPrice));
    }

    @Test
    public void checkout_return_item_B_price_for_item_B_in_basket() {
        String itemB = "B";
        Integer itemBPrice = 30;
        assertThat(Checkout.checkout(itemB), equalTo(itemBPrice));
    }

    @Test
    public void checkout_return_item_C_price_for_item_C_in_basket() {
        String itemC = "C";
        Integer itemCPrice = 20;
        assertThat(Checkout.checkout(itemC), equalTo(itemCPrice));
    }
}