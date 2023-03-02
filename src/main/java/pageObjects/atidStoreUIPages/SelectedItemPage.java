package pageObjects.atidStoreUIPages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedItemPage {

    @FindBy(xpath = "//button[contains(@name, 'add-to-cart')]")
    private WebElement addToCart;

    @FindBy(css = "div[class = \"woocommerce-notices-wrapper\"] a[class = \"button wc-forward\"]")
    private WebElement viewCart_Button;

    @Step("Click on 'add to cart' on chosen item")
    public void addToCartClick() {
        addToCart.click();
    }

    @Step("Click on 'view cart' after item was added")
    public void viewCartItemButtonClick() {
        viewCart_Button.click();
    }
}
