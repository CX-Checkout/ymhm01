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
    @Parameters({ "A, 50", "B, 30", "C, 20", "D, 15" })
    public void checkout_return_item_A_price_for_item_A_in_basket(String item, int amount) {
        assertThat(Checkout.checkout(item), equalTo(amount));
    }
/*
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

    @Test
    public void checkout_return_item_D_price_for_item_D_in_basket() {
        String itemD = "D";
        Integer itemDPrice = 15;
        assertThat(Checkout.checkout(itemD), equalTo(itemDPrice));
    }

    @Test
    public void checkout_return_minus_one_for_invalid_item_in_basket() {
        String invalidItem = "W";
        Integer invalidPrice = -1;
        assertThat(Checkout.checkout(invalidItem), equalTo(invalidPrice));
    }

    @Test
    public void checkout_return_80_price_for_item_AB_in_basket() {
        String items = "AB";
        Integer amount = 80;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }

    @Test
    public void checkout_return_130_price_for_item_AAA_in_basket() {
        String items = "AAA";
        Integer amount = 130;
        assertThat(Checkout.checkout(items), equalTo(amount));
    }*/
}
