package hw3.pages.nativeApp;

import hw3.constants.MobileConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    @FindBy(id = MobileConstants.APP_PACKAGE + "registration_email")
    private WebElement emailTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "registration_username")
    private WebElement usernameTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "registration_password")
    private WebElement passwordTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "registration_confirm_password")
    private WebElement confirmPasswordTextField;

    @FindBy(id = MobileConstants.APP_PACKAGE + "register_new_account_button")
    private WebElement registerButton;

    public RegistrationPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(final String email) {
        emailTextField.sendKeys(email);
    }

    public void setUsernameTextField(final String username) {
        usernameTextField.sendKeys(username);
    }

    public void setPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void setConfirmPasswordTextField(final String password) {
        confirmPasswordTextField.sendKeys(password);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
