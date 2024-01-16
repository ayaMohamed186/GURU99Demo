package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P03_AddNewCustomerPage {
    WebDriver driver;

    public P03_AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By customerName = By.xpath("//input[@name='name']");
    private final By gender = By.xpath("(//input[@type='radio'])[2]");
    private final By dateOfBirth = By.xpath("//input[@id='dob']");
    private final By addressInputField = By.xpath("//textarea[@name='addr']");
    private final By cityInputField = By.xpath("//input[@name='city']");
    private final By stateInputField = By.xpath("//input[@name='state']");
    private final By pinInputField = By.xpath("//input[@name='pinno']");
    private final By phoneInputField = By.xpath("//input[@name='telephoneno']");
    private final By emailInputField = By.xpath("//input[@name='emailid']");
    private final By passwordInputField = By.xpath("//input[@name='password']");
    private final By submitBtn = By.xpath("//input[@name='sub']");
    private final By successMsgAfterCreate = By.xpath("//p[@class='heading3']");
    private final By continueBtn = By.xpath("//table[@name='customer']/tbody/tr[14]/td/a");
    private final By customerID = By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]");


    public P03_AddNewCustomerPage fillCustomerName(String name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.customerName));
        driver.findElement(this.customerName).sendKeys(name);
        return this;
    }

    public P03_AddNewCustomerPage selectGender() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.gender));
        driver.findElement(By.xpath("(//input[@type='radio'])[" + generateRandomInt(2) + "]")).click();
        return this;
    }

    public P03_AddNewCustomerPage fillDateOfBirth(String DOF) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.dateOfBirth));
        driver.findElement(this.dateOfBirth).sendKeys(DOF);
        return this;
    }

    public P03_AddNewCustomerPage fillAddress(String Address) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.addressInputField));
        driver.findElement(this.addressInputField).sendKeys(Address);
        return this;
    }

    public P03_AddNewCustomerPage fillCity(String City) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cityInputField));
        driver.findElement(this.cityInputField).sendKeys(City);
        return this;
    }

    public P03_AddNewCustomerPage fillState(String State) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.stateInputField));
        driver.findElement(this.stateInputField).sendKeys(State);
        return this;
    }

    public P03_AddNewCustomerPage fillPin(String PIN) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.pinInputField));
        driver.findElement(this.pinInputField).sendKeys(PIN);
        return this;
    }

    public P03_AddNewCustomerPage fillPhone(String phone) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.phoneInputField));
        driver.findElement(this.phoneInputField).sendKeys(phone);
        return this;
    }

    public P03_AddNewCustomerPage fillEmail(String Email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.emailInputField));
        driver.findElement(this.emailInputField).sendKeys(Email);
        return this;
    }

    public P03_AddNewCustomerPage fillPassword(String Password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(Password);
        return this;
    }

    public P03_AddNewCustomerPage clickOnSubmit() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.submitBtn));
        driver.findElement(this.submitBtn).click();
        return this;
    }


    public String getCustomerAddedMsg() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.successMsgAfterCreate));
        return driver.findElement(this.successMsgAfterCreate).getText();
    }


    public P03_AddNewCustomerPage clickOnContinue() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
    public String getCustomerAddedID(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.customerID));
        return driver.findElement(this.customerID).getText();
    }
}
