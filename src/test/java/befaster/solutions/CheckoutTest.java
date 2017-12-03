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
    @Parameters({ "A, 50", "B, 30", "C, 20", "D, 15", "W, -1", "AB, 80", "AAA, 130", "BB, 45", "BBAAA, 175", "BBB, 75" })
    public void checkout_return_total_amount_for_items_in_basket(String items, int amount) {
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_180_price_for_item_AAAA_in_basket() {
        String items = "AAAA";
        Integer amount = 180;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_200_price_for_item_AAAAA_in_basket() {
        String items = "AAAAA";
        Integer amount = 200;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_80_price_for_item_EEB_in_basket() {
        String items = "EEB";
        Integer amount = 80;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_70_price_for_item_EB_in_basket() {
        String items = "EB";
        Integer amount = 70;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_160_price_for_item_EEEEBB_in_basket() {
        String items = "EEEEBB";
        Integer amount = 160;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }
}