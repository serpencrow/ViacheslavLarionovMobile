package hw3.nativeApp;

import hw3.constants.MobileConstants;
import hw3.constants.UserConstants;
import hw3.pages.nativeApp.BudgetActivityPage;
import hw3.pages.nativeApp.LoginPage;
import hw3.pages.nativeApp.RegistrationPage;
import hw3.setup.DriverSetup;
import hw3.utils.User;
import hw3.utils.UserPropertiesReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = {"native"}, description = "Using EPAMTestApp")
public class NativeAppTest extends DriverSetup {

    private User user;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private BudgetActivityPage activityPage;

    @BeforeMethod
    public void setUp() throws Exception {
        user = UserPropertiesReader.getUser(UserConstants.USER_PROPERTIES_PATH);
        loginPage = new LoginPage(getDriver());
        registrationPage = new RegistrationPage(getDriver());
        activityPage = new BudgetActivityPage(getDriver());
    }

    public void nativeAppTest() {
        // Go to registration page
        loginPage.clickOnRegistrationButton();
        driverWait().until(ExpectedConditions.visibilityOf(registrationPage.getEmailTextField()));

        // Register new user
        registrationPage.setEmailTextField(user.getEmail());
        registrationPage.setUsernameTextField(user.getUsername());
        registrationPage.setPasswordTextField(user.getPassword());
        registrationPage.setConfirmPasswordTextField(user.getPassword());
        registrationPage.clickOnRegisterButton();

        // Login from new user
        driverWait().until(ExpectedConditions.visibilityOf(loginPage.getLoginTextField()));
        loginPage.setLoginTextField(user.getEmail());
        loginPage.setPasswordTextField(user.getPassword());
        loginPage.clickLoginButton();

        // Check that page title is the same as we expected
        driverWait().until(ExpectedConditions.presenceOfElementLocated(activityPage.getActionBarBy()));
        assertEquals(activityPage.getPageTitleElement().getText(), MobileConstants.BUDGET_ACTIVITY_TITLE);
    }
}
