package testcases;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P04_EditCustomerPage;
import util.Utility;

import java.io.IOException;

import static testcases.TC02_CreateNewCustomer.customerCreatedId;

public class TC03_EditCustomer extends TestBase{
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");

    public TC03_EditCustomer() throws IOException, ParseException {
    }

    @Test(priority = 1, description = "Edit Customer Information")
    public void editCustomer(){
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();
        new P02_HomePage(driver).clickOnEditCustomer();
        new P04_EditCustomerPage(driver).fillCustomerId(customerCreatedId).clickOnSubmit();
        new P04_EditCustomerPage(driver).editAddress().editCity().editPhoneNo().clickSubmitEditBtn();

        Utility.captureScreenshot(driver, "EditCustomer");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(new P04_EditCustomerPage(driver).validateEditCustomer());
        softAssert.assertAll();

    }

}
