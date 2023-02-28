package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./config/config.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();


        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }

        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType) {
        if (browserType.equals(getData("BrowserName"))) {
            driver = initChromeDriver();
        } else if (browserType.equals(getData("BrowserName"))) {
            driver = initEdgeDriver();
        } else if (browserType.equals(getData("BrowserName"))) {
            driver = initFireFoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("ImplicitlyWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("ExplicitlyWait")));
        driver.get(getData("AtidStoreUrl"));
        ManagePages.initAtidStoreWebPages();
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("api-user"), getData("api-pass"));
    }

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, "ce051715d2374c3d03");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shivgadhia.android.ukMortgageCalc");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        try {
            mobileDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (Exception e) {
            System.out.println("Can not connect appium server , see details: " + e);
            mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("ImplicitlyWait")), TimeUnit.SECONDS);
        }
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("ImplicitlyWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("ImplicitlyWait")));
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    @AfterMethod
    public void goToHome() {
        if (!getData("BrowserName").equals("api") && !getData("BrowserName").equals("mobile")) {
            driver.get(getData("AtidStoreUrl"));
        }
    }

    @BeforeClass
    public void startSession() {
        if (getData("BrowserName").equals("api")) {
            initAPI();
        } else if(getData("BrowserName").equals("chrome")){
            initBrowser("chrome");
        } else {
            initMobile();
        }
    }

    @AfterClass
    public void closeSession() {
        if (!getData("BrowserName").equals("api") && !getData("BrowserName").equals("mobile")) {
            driver.quit();
        }
    }
}
