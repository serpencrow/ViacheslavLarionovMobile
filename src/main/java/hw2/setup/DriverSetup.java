package hw2.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class DriverSetup {

    private static AppiumDriver driver = null;
    private static WebDriverWait waitSingle = null;
    protected static String SUT = null;

    protected void prepareDriver() throws Exception {
        String AUT = PropertyReader.getProperty("aut");
        SUT = PropertyReader.getProperty("sut");
        String BROWSER = PropertyReader.getProperty("browser");
        String PLATFORM = PropertyReader.getProperty("platform");
        String DRIVER = PropertyReader.getProperty("driver");
        String DEVICE = PropertyReader.getProperty("device");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilities.DEVICE_NAME, DEVICE);
        capabilities.setCapability(MobileCapabilities.PLATFORM_NAME, PLATFORM);

        if (AUT != null && SUT == null) {
            capabilities.setCapability(MobileCapabilities.APP, AUT);
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilities.BROWSER_NAME, BROWSER);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        if (driver == null) {
            driver = new AppiumDriver(new URL(DRIVER), capabilities);
        }
    }

    protected AppiumDriver getDriver() throws Exception {
        if (driver == null)
            prepareDriver();
        return driver;
    }

    protected WebDriverWait driverWait() {
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver, 20);
        }
        return waitSingle;
    }
}
