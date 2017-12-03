package befaster.solutions;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitParamsRunner.class)
public class CheckoutTest {

    @Test
    @Parameters({ "A, 50", "B, 30", "C, 20", "D, 15", "W, -1", "AB, 80" })
    public void checkout_return_item_A_price_for_item_A_in_basket(String item, int amount) {
        assertThat(Checkout.checkout(item), equalTo(amount));
    }

    @Test
    public void checkout_return_130_price_for_item_AAA_in_basket() {
        String items = "AAA";
        Integer amount = 130;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }
    @Test
    public void checkout_return_45_price_for_item_BB_in_basket() {
        String items = "BB";
        Integer amount = 45;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }
}