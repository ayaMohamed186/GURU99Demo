package testcases;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P03_AddNewCustomerPage;
import pages.P06_NewAccountPage;
import util.Utility;

import java.io.IOException;

public class TC05_New_Account extends TestBase {

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
    String Deposit = faker.number().digits(4);

    String customerCreatedId2;
    static String accountCreatedId ;
    public TC05_New_Account() throws IOException, ParseException {
    }

    @Test(priority = 1, description = "Add New Account")
    public void addNewAccount(){
        new P01_LoginPage(driver).fillUserID(userId).fillPassword(password).clickLogin();

        new P02_HomePage(driver).clickOnNewCustomer();
        new P03_AddNewCustomerPage(driver).fillCustomerName(customerName).selectGender().fillDateOfBirth(dob).fillAddress(address).
                fillCity(city).fillState(state).fillPin(pin).fillPhone(phone).fillEmail(email).fillPassword(passwordForNewCustomer).clickOnSubmit();
        customerCreatedId2 = new P03_AddNewCustomerPage(driver).getCustomerAddedID();

        new P02_HomePage(driver).clickOnAddAccount();
        new P06_NewAccountPage(driver).fillCustomerId(customerCreatedId2).selectAccountType().fillInitialDeposit(Deposit).
                clickOnSubmitBtn();
        accountCreatedId = new P06_NewAccountPage(driver).getAccountCreatedId();

        Assert.assertEquals(new P06_NewAccountPage(driver).getSuccessMsgOfNewAccount() , "Account Generated Successfully!!!");

    }
}
