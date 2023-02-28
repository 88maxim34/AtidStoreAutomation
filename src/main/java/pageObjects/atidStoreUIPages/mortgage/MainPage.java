package pageObjects.atidStoreUIPages.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {
    private AppiumDriver mobileDriver ;


    public MainPage(AppiumDriver mobileDriver)  {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }


    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    public AndroidElement txt_amount;

    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    public AndroidElement txt_term;

    @AndroidFindBy(xpath = "//*[@id='etRate']")
    public AndroidElement txt_rate;

    @AndroidFindBy(xpath = "//*[@text='Calculate']")
    public AndroidElement calculate_btn;

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_repayment;
}
