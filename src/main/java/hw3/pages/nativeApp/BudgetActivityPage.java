package hw3.pages.nativeApp;

import hw3.constants.MobileConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BudgetActivityPage {

    private By actionBarBy = By.id(MobileConstants.APP_PACKAGE + "action_bar");

    @FindBy(id = MobileConstants.APP_PACKAGE + "action_bar")
    WebElement actionBar;

    public BudgetActivityPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By getActionBarBy() {
        return actionBarBy;
    }

    public WebElement getPageTitleElement() {
        return actionBar.findElement(By.className("android.widget.TextView"));
    }
}
