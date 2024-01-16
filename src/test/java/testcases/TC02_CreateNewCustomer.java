package testcases;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P03_AddNewCustomerPage;
import util.Utility;

import java.io.IOException;

public class TC02_CreateNewCustomer extends TestBase {
    String userId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String customerName = faker.name().firstName();
    String dob = "09252013";
    String address = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String pin = faker.number().digits(6);
    String phone = faker.phoneNumber().subscriberNumber(11);
    String email = faker.internet().emailAddress();
    static String passwordForNewCustomer =faker.internet().password();
    static String customerCreatedId;
    public TC02_CreateNewCustomer() throws IOException, ParseException {
    }


    @Test(priority = 1, description = "Create New Customer ")
    public void createNewCustomer(){
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();
        new P02_HomePage(driver).clickOnNewCustomer();
        new P03_AddNewCustomerPage(driver).fillCustomerName(customerName).selectGender().fillDateOfBirth(dob).fillAddress(address).
                fillCity(city).fillState(state).fillPin(pin).fillPhone(phone).fillEmail(email).fillPassword(passwordForNewCustomer).clickOnSubmit();

       Utility.captureScreenshot(driver, "Create New Customer");
       Assert.assertTrue(new P03_AddNewCustomerPage(driver).getCustomerAddedMsg().equals("Customer Registered Successfully!!!"));
       customerCreatedId = new P03_AddNewCustomerPage(driver).getCustomerAddedID();

       new P03_AddNewCustomerPage(driver).clickOnContinue();
    }
}
