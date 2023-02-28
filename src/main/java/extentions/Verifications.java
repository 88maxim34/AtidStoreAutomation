package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Verifications extends CommonOps {

    @Step("verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual,String expected) {
        assertEquals(actual,expected);
    }

    @Step("Verify Element not Displayed")
    public static void notExistenceOfElement(List<WebElement> elements) throws InterruptedException {
        Thread.sleep(2000);
        assertFalse(elements.size() > 0);
    }
}
