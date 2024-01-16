package testcases;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P07_Edit_Account;
import util.Utility;

import java.io.IOException;

import static testcases.TC05_New_Account.accountCreatedId;

public class TC06_Edit_Account extends TestBase{
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");

    public TC06_Edit_Account() throws IOException, ParseException {
    }

    @Test(priority = 1, description = "Edit Account")
    public void editAccount() throws InterruptedException {
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();
        new P02_HomePage(driver).clickOnEditAccount();
        new P07_Edit_Account(driver).fillAccountNo(accountCreatedId).clickOnSubmitBtn();

        Thread.sleep(15000);
    }
}

