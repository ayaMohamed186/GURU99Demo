package testcases;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P05_DeleteCustomerPage;
import pages.P08_DeleteAccountPage;
import util.Utility;

import java.io.IOException;

import static testcases.TC05_New_Account.accountCreatedId;

public class TC07_DeleteAccount extends TestBase{
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");

    public TC07_DeleteAccount() throws IOException, ParseException {
    }

    @Test(priority = 1 , description = " delete account")
    public void deleteAccount(){
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();
        new P02_HomePage(driver).clickOnDeleteAccount();

        new P08_DeleteAccountPage(driver).fillAccountNo(accountCreatedId).clickOnSubmitBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( new P08_DeleteAccountPage(driver).getAlertMsg() , "Customer does not Exist!!!");
        softAssert.assertAll();
    }
}
