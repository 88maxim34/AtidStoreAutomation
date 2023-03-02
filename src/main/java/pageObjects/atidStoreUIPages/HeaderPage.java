package pageObjects.atidStoreUIPages;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends UIActions {

    @FindBy(css = "div[id = \"ast-desktop-header\"] ul[id = \"ast-hf-menu-1\"] li a")
    private static List<WebElement> headerList;

    @FindBy(css = "div[id = \"ast-site-header-cart\"]")
    private static WebElement cartIcon;

    @Step("Header option picker")
    public void headerItemPicker(String headerItem){
        for(WebElement headerOption : headerList){
            if(headerOption.getText().equals(headerItem)){
                UIActions.click(headerOption);
                break;
            }
        }
    }

    @Step("Click home page cart icon")
    public void clickCartIcon(){
        UIActions.click(cartIcon);
    }
}

