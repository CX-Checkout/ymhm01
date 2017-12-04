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
    @Parameters({"AB, 80", "AAA, 130", "BB, 45", "AAAAAAAAA, 380",
            "BBAAA, 175", "BBB, 75", "AAAA, 180", "AAAAA, 200",
            "KK, 150", "PPPPP, 200", "QQQ, 80"})
    public void checkout_return_total_amount_for_items_with_discounts_in_basket(String items, int amount) {
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    @Parameters({"EEB, 80", "EB, 70", "EEEEBB, 160", "EEEB, 120",
            "BEBBBBEE, 210", "ABCDECBAABCABBAAAEEAA, 665",
            "FFF, 20", "FF, 20", "FFFFFF, 40", "FFFF, 30"
            , "NNNM, 120", "RRRQ, 150", "UUU, 80"})
    public void checkout_return_total_amount_for_item_with_cross_product_discounts_in_basket(String items, int amount) {
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    //todo refactor and clean tests
    //todo extract cross product discounts (into visitor pattern??)
    //todo extract line item discounts
}
