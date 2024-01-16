package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P07_Edit_Account {
    WebDriver driver;

    public P07_Edit_Account(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountNo = By.xpath("//input[@name='accountno']");
    private final By submitEditAccBtn = By.xpath("//input[@name='AccSubmit']");

    public P07_Edit_Account fillAccountNo(String AccountNo) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.accountNo));
        driver.findElement(this.accountNo).sendKeys(AccountNo);
        return this;
    }


    public P07_Edit_Account clickOnSubmitBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitEditAccBtn));

        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.submitEditAccBtn).click();
        return this;
    }
}
