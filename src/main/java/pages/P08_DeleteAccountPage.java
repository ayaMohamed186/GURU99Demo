package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P08_DeleteAccountPage {

    WebDriver driver;

    public P08_DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountNo = By.xpath("//input[@name='accountno']");
    private final By submitDeleteAccBtn = By.xpath("//input[@name='AccSubmit']");

    public P08_DeleteAccountPage fillAccountNo(String AccountNo) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.accountNo));
        driver.findElement(this.accountNo).sendKeys(AccountNo);
        return this;
    }


    public P08_DeleteAccountPage clickOnSubmitBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitDeleteAccBtn));

        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitDeleteAccBtn).click();
        return this;
    }
    public String getAlertMsg(){
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();
        return alertMsg;
    }
}
