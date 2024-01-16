package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P02_HomePage {
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By newCustomerBtn = By.xpath("//ul[@class='menusubnav']/li[2]/a");
    private final By editCustomerBtn = By.xpath("//a[@href='EditCustomer.php']");

    private final By deleteCustomerBtn = By.xpath("//ul[@class='menusubnav']/li[4]/a");
    private final By addAccountBtn = By.xpath("//ul[@class='menusubnav']/li[5]/a");
    private final By editAccountBtn = By.xpath("//ul[@class='menusubnav']/li[6]/a");
    private final By deleteAccountBtn = By.xpath("//ul[@class='menusubnav']/li[7]/a");

    public P02_HomePage clickOnNewCustomer() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.newCustomerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.newCustomerBtn).click();
        return this;
    }
    public P02_HomePage clickOnEditCustomer() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.editCustomerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.editCustomerBtn).click();
        return this;
    }
    public P02_HomePage clickOnDeleteCustomer() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.deleteCustomerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.deleteCustomerBtn).click();
        return this;
    }
    public P02_HomePage clickOnAddAccount() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addAccountBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.addAccountBtn).click();
        return this;
    }
    public P02_HomePage clickOnEditAccount() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.editAccountBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.editAccountBtn).click();
        return this;
    }
    public P02_HomePage clickOnDeleteAccount() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.deleteAccountBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.deleteAccountBtn).click();
        return this;
    }
}
