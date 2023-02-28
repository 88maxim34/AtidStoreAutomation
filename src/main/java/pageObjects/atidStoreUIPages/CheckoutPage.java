package pageObjects.atidStoreUIPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage {

    @FindBy(css = "input[id = \"billing_first_name\"]")
    private WebElement firstName_input;

    @FindBy(css = "input[id = \"billing_last_name\"]")
    private WebElement lastName_input;

    @FindBy(css = "select[id = \"billing_country\"]")
    private WebElement country_select;

    @FindBy(css = "input[id = \"billing_address_1\"]")
    private WebElement streetAddress_input;

    @FindBy(css = "input[id = \"billing_postcode\"]")
    private WebElement postCode_input;

    @FindBy(css = "input[id = \"billing_city\"]")
    private WebElement city_input;

    @FindBy(css = "input[id = \"billing_phone\"]")
    private WebElement phoneNumber_input;

    @FindBy(css = "input[id = \"billing_email\"]")
    private WebElement email_input;

    @FindBy(css = "button[id = \"place_order\"]")
    private WebElement placeOrder_button;

    @FindBy(css = "ul[id = \"shipping_method\"] label")
    private static List<WebElement> checkBoxShipping;

    public void fillFullName(String firstName, String lastName) {
        firstName_input.sendKeys(firstName);
        lastName_input.sendKeys(lastName);
    }

    public void selectCountry(String countryName) {
        Select myCountries = new Select(country_select);
        myCountries.selectByVisibleText(countryName);
    }

    public void fillStreetAddress(String street) {
        streetAddress_input.sendKeys(street);
    }

    public void fillPostCode(String postCode) {
        postCode_input.sendKeys(postCode);
    }

    public void fillCity(String city) {
        city_input.sendKeys(city);
    }

    public void fillPhoneNumber(String phone) {
        phoneNumber_input.sendKeys(phone);
    }

    public void fillEmail(String email) {
        email_input.sendKeys(email);
    }

    public void placeOrder() {
        placeOrder_button.click();
    }

    public void fillPersonalForm(
            String firstName, String lastName, String countryName,
            String streetName, String postCode, String cityName,
            String phoneNumber, String emailName, String shippingOption)
    {
        fillFullName(firstName, lastName);
        selectCountry(countryName);
        fillStreetAddress(streetName);
        fillPostCode(postCode);
        fillCity(cityName);
        fillPhoneNumber(phoneNumber);
        fillEmail(emailName);
        pickShipping(shippingOption);
        placeOrder();
    }


    public void pickShipping(String shippingOption) {
        for (WebElement option : checkBoxShipping) {
            if(option.getText().contains(shippingOption)){
                option.click();
            }
        }
    }

}
