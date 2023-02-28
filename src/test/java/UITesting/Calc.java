package UITesting;

import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Calc {

    WebDriver driver;
    WebDriverWait wait;
    List<String> expectedResults = Arrays.asList("9", "6", "3", "6", "4", "2", "3", "2", "1");

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://juliemr.github.io/protractor-demo/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void test01() throws InterruptedException {
//        List<WebElement> operatorsList = driver.findElements(By.cssSelector("select[ng-model = 'operator'] option"));
//        for (WebElement operator : operatorsList) {
//            if (operator.getText().equals("*")) {
//                operator.click();
//                break;
//            }
//        }
        // Example 1 - Nested loop
//        for (int i = 3; i >= 1; i--) {
//            for (int j = 3; j >= 1; j--) {
//                driver.findElement(By.xpath("//input[contains(@ng-model,'first')]")).sendKeys(Integer.toString(i));
//                driver.findElement(By.xpath("//input[contains(@ng-model,'second')]")).sendKeys(Integer.toString(j));
//                driver.findElement(By.xpath("//button[contains(@ng-click,'doAddition()')]")).click();
//                WebElement myCurrentResult = driver.findElement(By.xpath("//tr[@ng-repeat = 'result in memory'][1]//td[contains(text(), '" + i * j + "')][1]"));
//                wait.until(ExpectedConditions.visibilityOf(myCurrentResult));
//                String finalRes = myCurrentResult.getText();
//                System.out.println(finalRes);
//            }
//        }

        // Example 2 - Single loop
//        for (int k = 3 * 3 - 1; k >= 0; k--) {
//            int i = k / 3 + 1;
//            int j = k % 3 + 1;
//            driver.findElement(By.xpath("//input[contains(@ng-model,'first')]")).sendKeys(Integer.toString(i));
//            driver.findElement(By.xpath("//input[contains(@ng-model,'second')]")).sendKeys(Integer.toString(j));
//            driver.findElement(By.xpath("//button[contains(@ng-click,'doAddition()')]")).click();
//            WebElement myCurrentResult = driver.findElement(By.xpath("//tr[@ng-repeat = \"result in memory\"][1]//td[@class = \"ng-binding\" and text() = \"" + i * j + "\"]"));
//            wait.until(ExpectedConditions.visibilityOf(myCurrentResult));
//            String finalRes = myCurrentResult.getText();
//            System.out.println(finalRes);
//        }

        // Example 3 - Using a method
        List<String> calculationResults = doCalculation(3, "*", 3);
        System.out.println(calculationResults);
        Assert.assertEquals(calculationResults, expectedResults);
    }


    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    public List<String> doCalculation(int num1, String operator, int num2) {
        List<WebElement> operatorsList = driver.findElements(By.cssSelector("select[ng-model = 'operator'] option"));
        for (WebElement op : operatorsList) {
            if (op.getText().equals(operator)) {
                op.click();
                break;
            }
        }
        List<String> results = new ArrayList<>();
        for (int k = num1 * num2 - 1; k >= 0; k--) {
            int first = k / num1 + 1;
            int second = k % num2 + 1;
            int result = first * second;
            driver.findElement(By.xpath("//input[contains(@ng-model,'first')]")).sendKeys(Integer.toString(first));
            driver.findElement(By.xpath("//input[contains(@ng-model,'second')]")).sendKeys(Integer.toString(second));
            driver.findElement(By.xpath("//button[contains(@ng-click,'doAddition()')]")).click();
            WebElement myCurrentResult = driver.findElement(By.xpath("//tr[@ng-repeat = 'result in memory'][1]//td[@class = 'ng-binding' and text() = " + result + "]"));
            wait.until(ExpectedConditions.visibilityOf(myCurrentResult));
            results.add(myCurrentResult.getText());
        }
        return results;
    }

}


