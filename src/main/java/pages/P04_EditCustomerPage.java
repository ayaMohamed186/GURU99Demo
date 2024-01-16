package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P04_EditCustomerPage {
    WebDriver driver;


    public P04_EditCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CustomerIDInputField = By.xpath("//input[@name='cusid']");
    private final By submitCustomerIdBtn = By.xpath("//input[@name='AccSubmit']");
    private final By editAddressInputField = By.xpath("//textarea[@name='addr']");
    private final By editCityInputField = By.xpath("//input[@name='city']");
    private final By editPhoneInputField = By.xpath("//input[@name='telephoneno']");
    private final By submitEditBtn = By.xpath("//input[@type=\"submit\"]");
    private final By editForm = By.xpath("//p[@align='center']");


    public P04_EditCustomerPage fillCustomerId(String CustomerID) {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.CustomerIDInputField));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.CustomerIDInputField).sendKeys(CustomerID);
        return this;
    }

    public P04_EditCustomerPage clickOnSubmit() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitCustomerIdBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitCustomerIdBtn).click();
        return this;
    }


    public P04_EditCustomerPage editAddress() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.editAddressInputField));
        driver.findElement(this.editAddressInputField).sendKeys(Keys.DELETE);
        driver.findElement(this.editAddressInputField).sendKeys("test address");
        return this;
    }

    public P04_EditCustomerPage editCity() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.editCityInputField));
        driver.findElement(this.editCityInputField).sendKeys(Keys.DELETE);
        driver.findElement(this.editCityInputField).sendKeys("test city");
        return this;
    }

    public P04_EditCustomerPage editPhoneNo() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.editPhoneInputField));
        driver.findElement(this.editPhoneInputField).sendKeys(Keys.DELETE);
        driver.findElement(this.editPhoneInputField).sendKeys("011123654789");
        return this;
    }


    public P04_EditCustomerPage clickSubmitEditBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitEditBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitEditBtn).click();
        return this;
    }


    public boolean validateEditCustomer() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.editForm));
        return driver.findElement(this.editForm).isDisplayed();

    }


}
