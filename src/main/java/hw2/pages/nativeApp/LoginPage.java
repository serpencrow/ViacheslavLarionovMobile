package hw2.pages.nativeApp;

import hw2.constants.MobileConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = MobileConstants.APP_PACKAGE + "register_button")
    private WebElement registerButton;

    @FindBy(id = MobileConstants.APP_PACKAGE + "login_email")
    private WebElement loginTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "login_pwd")
    private WebElement passwordTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "email_sign_in_button")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginTextField() {
        return loginTextField;
    }

    public void clickOnRegistrationButton() {
        registerButton.click();
    }

    public void setLoginTextField(final String email) {
        loginTextField.sendKeys(email);
    }

    public void setPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
