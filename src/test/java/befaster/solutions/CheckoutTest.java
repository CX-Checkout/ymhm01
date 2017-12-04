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
    @Parameters({"A, 50", "B, 30", "C, 20", "D, 15",
            "E, 40", "F, 10", "G, 20", "H, 10", "I, 35",
            "J, 60", "K, 80", "L, 90", "M, 15", "N, 40",
            "O, 10", "P, 50", "Q, 30", "R, 50", "S, 30",
            "T, 20", "U, 40", "V, 50", "W, 20", "X, 90",
            "Y, 10", "Z, 50", "@, -1"})
    public void checkout_return_item_price_for_single_item_in_basket(String item, int amount) {
        assertThat(Checkout.checkout(item), equalTo(amount));
    }

    @Test
    @Parameters({"AB, 80", "AAA, 130", "BB, 45", "BBAAA, 175", "BBB, 75"})
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

    @Test
    public void checkout_return_120_price_for_item_EEEB_in_basket() {
        String items = "EEEB";
        Integer amount = 120;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_380_price_for_item_AAAAAAAAA_in_basket() {
        String items = "AAAAAAAAA";
        Integer amount = 380;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_230_price_for_item_BEBBBBEE_in_basket() {
        String items = "BEBBBBEE";
        Integer amount = 210;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_665_price_for_item_ABCDECBAABCABBAAAEEAA_in_basket() {
        String items = "ABCDECBAABCABBAAAEEAA";
        Integer amount = 665;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_20_price_for_item_FFF_in_basket() {
        String items = "FFF";
        Integer amount = 20;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_20_price_for_item_FF_in_basket() {
        String items = "FF";
        Integer amount = 20;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_40_price_for_item_FFFFFF_in_basket() {
        String items = "FFFFFF";
        Integer amount = 40;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_30_price_for_item_FFFF_in_basket() {
        String items = "FFFF";
        Integer amount = 30;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    //todo refactor and clean tests
    //todo extract cross product discounts (into visitor pattern??)
    //todo extract line item discounts
}
