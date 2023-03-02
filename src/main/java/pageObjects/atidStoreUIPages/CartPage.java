package pageObjects.atidStoreUIPages;

import extentions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Base;

import java.util.List;

public class CartPage {

    @FindBy(css = "a[class = \"checkout-button button alt wc-forward\"]")
    private WebElement proceedToCheckout_button;

    @Step("Click on 'Proceed to check out'")
    public void proceedToCheckOutClick(){
        proceedToCheckout_button.click();
    }

    @FindBy(xpath = "//tr[@class = \"woocommerce-cart-form__cart-item cart_item\"]/td[@class = \"product-name\"]/a")
    private List<WebElement> cartItemsName_list;

    @FindBy(css = "tr[class = \"woocommerce-cart-form__cart-item cart_item\"]")
    private List<WebElement> cartItems_list;

    @FindBy(css = "tr[class = \"woocommerce-cart-form__cart-item cart_item\"]")
    private WebElement cartItems_list2;


    @Step("Delete an item from cart")
    public void deleteItemFromCart(String itemName){
        for(WebElement chosenItem : cartItemsName_list){
            if(chosenItem.getText().equals(itemName)){
                String itemTitle = "//tr[@class = \"woocommerce-cart-form__cart-item cart_item\"]/td[@class = \"product-name\"]/a[contains(text(), \""+ chosenItem.getText() +"\")]";
                String removeButton = "/td[@class = \"product-remove\"]/a[@class = \"remove\"]";
                WebElement myElement = Base.driver.findElement(By.xpath(itemTitle +"/../.."+ removeButton));
                myElement.click();
                break;
            }
        }
    }

    @Step("Verify an item was deleted from cart")
    public void verifyItemDeleted() throws InterruptedException {
        Verifications.notExistenceOfElement(cartItems_list);
    }

}
