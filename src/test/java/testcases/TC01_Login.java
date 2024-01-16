package testcases;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import util.Utility;

import java.io.IOException;

public class TC01_Login extends TestBase {
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String inValidUser = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/InValidlogindata.json", "inValidUser");
    String inValidPassword = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/InValidlogindata.json", "password");


    public TC01_Login() throws IOException, ParseException {
    }


    @Test(priority = 1, description = "Check Login With Valid Data")
    public void loginWithValidData_P() {
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();

        Utility.captureScreenshot(driver, "P_Login");

        Assert.assertTrue(new P01_LoginPage(driver).getWelcomeMsgForLoggedUser().contains(userId));
    }


    @Test(priority = 2, description = "Check Login With inValid User ID")
    public void loginWithInvalidUser_N() {
        new P01_LoginPage(driver).fillUserID(inValidUser).fillPassword(password).clickLogin();

        Utility.captureScreenshot(driver, "N_Login");
        Assert.assertFalse(new P01_LoginPage(driver).failUserLogin());
    }


    @Test(priority = 3, description = "Check Login With inValid User ID")
    public void loginWithInvalidPassword_N() {
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(inValidPassword).clickLogin();

        Utility.captureScreenshot(driver, "N_Login2");
        Assert.assertFalse(new P01_LoginPage(driver).failUserLogin());
    }

    @Test(priority = 4, description = "Check Login With inValid UserID & Password")
    public void loginWithInvalidData_N() {
        new P01_LoginPage(driver).fillUserID(inValidUser).fillPassword(inValidPassword).clickLogin();

        Utility.captureScreenshot(driver, "N_Login");
        Assert.assertFalse(new P01_LoginPage(driver).failUserLogin());
    }


}
