package UITesting;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;

@Listeners(utilities.Listeners.class)
public class BuyItemTests extends CommonOps {

    @Test(description = "Buy an item")
    @Description("Buying an item from the shop")
    public void Test01_buyItem() {
        headerPage.headerItemPicker("STORE");
        shopItems.searchProduct("Dark Brown Jeans");
        darkJeansButton.addToCartClick();
        darkJeansButton.viewCartItemButtonClick();
        cartPage.proceedToCheckOutClick();
        checkoutPage.fillPersonalForm(
                "Tal",
                "Shuv",
                "Israel",
                "Dereh HaMelech",
                "54321",
                "Haifa",
                "0541234567",
                "automationTesting@gmail.com",
                "Delivery Express"
        );
    }

    @Test(description = "Delete an item")
    @Description("Deleting an item from the cart")
    public void Test02_deleteItemFromCart() throws InterruptedException {
        Alert popUp = driver.switchTo().alert();
        popUp.accept();
        headerPage.clickCartIcon();
        cartPage.deleteItemFromCart("Dark Brown Jeans");
        cartPage.verifyItemDeleted();
    }
}