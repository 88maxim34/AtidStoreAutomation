package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.atidStoreUIPages.*;
//import pageObjects.atidStoreUIPages.mortgage.MainPage;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Atid Store - Web Pages
    public static HeaderPage headerPage;
    public static ShopItemsPage shopItems;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static SelectedItemPage darkJeansButton;

    // Mortgate App - Application Pages
    public static pageObjects.atidStoreUIPages.mortgage.MainPage mortgageMain;

    // Rest API
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject params = new JSONObject();
    public static JsonPath jp;

    // Mobile
    public static AppiumDriver mobileDriver;
    public static DesiredCapabilities dc = new DesiredCapabilities();
}
