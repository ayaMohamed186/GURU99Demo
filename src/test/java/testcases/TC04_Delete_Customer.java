package testcases;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P04_EditCustomerPage;
import pages.P05_DeleteCustomerPage;
import util.Utility;

import java.io.IOException;

import static testcases.TC02_CreateNewCustomer.customerCreatedId;

public class TC04_Delete_Customer extends TestBase {
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");

    public TC04_Delete_Customer() throws IOException, ParseException {
    }

    @Test(priority = 1, description = "Delete Customer")
    public void deleteCustomer() {
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();
        new P02_HomePage(driver).clickOnDeleteCustomer();
        new P05_DeleteCustomerPage(driver).fillCustomerId(customerCreatedId).clickOnSubmitDelete().getAlertMsg();

        Utility.captureScreenshot(driver, "DeleteCustomer");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( new P05_DeleteCustomerPage(driver).getAlertMsg() , "Customer does not Exist!!!");
        softAssert.assertAll();

    }
}

