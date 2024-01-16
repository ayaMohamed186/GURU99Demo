package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P06_NewAccountPage {
    WebDriver driver;

    public P06_NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By customerIDInputField = By.xpath("//input[@name='cusid']");
    private final By accountType = By.xpath("//select[@name='selaccount']");
    private final By initialDepositInputField = By.xpath("//input[@name='inideposit']");
    private final By submitAddNewAccount = By.xpath("//input[@type='submit']");
    private final By successMsgForNewAcc = By.xpath("//p[@class='heading3']");

    private final By accountCreatedId = By.xpath("//table[@id='account']/tbody/tr[4]/td[2]");

    public P06_NewAccountPage fillCustomerId(String CustomerID) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.customerIDInputField));
        driver.findElement(this.customerIDInputField).sendKeys(CustomerID);
        return this;
    }


    public P06_NewAccountPage selectAccountType() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.accountType));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.accountType).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.accountType).sendKeys(Keys.ENTER);
        return this;
    }


    public P06_NewAccountPage fillInitialDeposit(String initialDeposit) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.initialDepositInputField));
        driver.findElement(this.initialDepositInputField).sendKeys(initialDeposit);
        return this;
    }


    public P06_NewAccountPage clickOnSubmitBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitAddNewAccount));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitAddNewAccount).click();
        return this;
    }


    public String getSuccessMsgOfNewAccount() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.successMsgForNewAcc));
        return driver.findElement(this.successMsgForNewAcc).getText();
    }

    public String getAccountCreatedId(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.accountCreatedId));
        return driver.findElement(this.accountCreatedId).getText();
    }

}
