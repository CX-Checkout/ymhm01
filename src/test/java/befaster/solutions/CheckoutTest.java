package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutTest {

    @Test
    public void checkout_return_item_A_price_for_item_A_in_basket() {
        String itemA = "A";
        Double itemAPrice = 50;
        assertThat(Checkout.checkout(itemA), equalTo(itemAPrice));
    }
}