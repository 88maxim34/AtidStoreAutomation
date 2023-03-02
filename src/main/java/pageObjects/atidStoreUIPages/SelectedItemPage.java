package pageObjects.atidStoreUIPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedItemPage {

    @FindBy(xpath = "//button[contains(@name, 'add-to-cart')]")
    private WebElement addToCart;

    @FindBy(css = "div[class = \"woocommerce-notices-wrapper\"] a[class = \"button wc-forward\"]")
    private WebElement viewCart_Button;

    public void addToCartClick() {
        addToCart.click();
    }

    public void viewCartItemButtonClick() {
        viewCart_Button.click();
    }
}
