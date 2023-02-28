package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.atidStoreUIPages.*;

public class ManagePages extends Base {
    public static void initAtidStoreWebPages(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        shopItems = PageFactory.initElements(driver, ShopItemsPage.class);
        darkJeansButton = PageFactory.initElements(driver, SelectedItemPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }
}
