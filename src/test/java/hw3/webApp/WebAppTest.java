package hw3.webApp;

import hw3.constants.MobileConstants;
import hw3.pages.webApp.SearchPage;
import hw3.pages.webApp.SearchResultsPage;
import hw3.setup.DriverSetup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Test(groups = {"web"})
public class WebAppTest extends DriverSetup {

    private SearchPage searchPage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() throws Exception {
        searchPage = new SearchPage(getDriver());
        searchResultsPage = new SearchResultsPage(getDriver());
    }

    public void webAppTest() throws Exception {
        // Enter "EPAM" in google search
        getDriver().get(SUT);
        searchPage.setSearchField(MobileConstants.QUERY);

        // Check that result is not empty
        driverWait().until(ExpectedConditions.elementToBeClickable(searchPage.getSearchField()));
        assertTrue(searchResultsPage.getResults().size() > 0);
    }
}
