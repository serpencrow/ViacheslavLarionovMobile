package hw2.pages.webApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    private List<WebElement> results;

    public SearchResultsPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getResults() {
        return results;
    }
}
