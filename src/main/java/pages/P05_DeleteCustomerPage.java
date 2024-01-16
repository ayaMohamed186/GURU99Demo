package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P05_DeleteCustomerPage {
    WebDriver driver;
    public P05_DeleteCustomerPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By customerIDInputField =By.xpath("//input[@name='cusid']");
    private final By submitDeleteBtn =By.xpath("//input[@name='AccSubmit']");


    public P05_DeleteCustomerPage fillCustomerId(String CustomerID){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.customerIDInputField));
        driver.findElement(this.customerIDInputField).sendKeys(CustomerID);
        return this;
    }
    public P05_DeleteCustomerPage clickOnSubmitDelete(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.submitDeleteBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        driver.findElement(this.submitDeleteBtn).click();
        return this;
    }

    public String getAlertMsg(){
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();
        return alertMsg;
    }
}
