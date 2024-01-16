package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P01_LoginPage {
    WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userID = By.xpath("//input[@name='uid']");
    private final By password = By.xpath("//input[@name='password']");
    private final By submitLoginBtn = By.xpath("//input[@name='btnLogin']");
    private final By welcomeMsgForLogin = By.xpath("//tr[@align='center']/td");

    public P01_LoginPage fillUserID(String UserID) {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userID));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.userID).sendKeys(UserID);
        return this;
    }

    public P01_LoginPage fillPassword(String Password) {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.password).sendKeys(Password);
        return this;
    }


    public P01_LoginPage clickLogin() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitLoginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitLoginBtn).click();
        return this;
    }

    public String getWelcomeMsgForLoggedUser() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.welcomeMsgForLogin));
        return driver.findElement(this.welcomeMsgForLogin).getText();
    }

    public boolean failUserLogin() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userID));
        return driver.findElement(this.userID).isDisplayed();
    }

}
