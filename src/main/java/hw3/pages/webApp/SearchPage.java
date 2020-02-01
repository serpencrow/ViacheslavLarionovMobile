package hw3.pages.webApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(name = "q")
    private WebElement searchField;

    public SearchPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void setSearchField(String query) {
        searchField.sendKeys(query + Keys.ENTER);
    }
}
