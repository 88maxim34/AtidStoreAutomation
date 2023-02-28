package pageObjects.atidStoreUIPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShopItemsPage {

    @FindBy(xpath = "//h1[contains(text(), 'Men')]")
    private WebElement menTitle;

    @FindBy(css = "input[id = \"wc-block-search__input-1\"]")
    private WebElement searchItem_Field;

    @FindBy(css = "button[class = \"wc-block-product-search__button\"]")
    private WebElement searchItems_Button;

    public void verifyTitleName(String expectedRes) {
        Assert.assertEquals(menTitle.getText(), expectedRes);
    }

    public void searchProduct(String itemName){
        searchItem_Field.sendKeys(itemName);
        searchItems_Button.click();
    }


}
