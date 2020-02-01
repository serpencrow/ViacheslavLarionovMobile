package hw3.setup;

import hw3.api.MobileCloudApi;
import hw3.constants.MobileCloudApiConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static hw3.api.MobileCloudApi.mobileCloudApiBuilder;
import static hw3.constants.MobileConstants.APP_ACTIVITY_TYPE;
import static hw3.constants.MobileConstants.APP_PACKAGE_TYPE;

public class DriverSetup {

    private static AppiumDriver driver = null;
    private static WebDriverWait waitSingle = null;
    protected static String SUT = null;

    protected void prepareDriver() throws Exception {
        // Read base properties
        String AUT = PropertyReader.getProperty("aut");
        SUT = PropertyReader.getProperty("sut");
        String BROWSER = PropertyReader.getProperty("browser");
        String PLATFORM = PropertyReader.getProperty("platform");
        String UDID = PropertyReader.getProperty("udid");
        String APP_PACKAGE = PropertyReader.getProperty("app_package");
        String APP_ACTIVITY = PropertyReader.getProperty("app_activity");

        // Set token in driver for mobile cloud
        String TOKEN = System.getenv(MobileCloudApiConstants.TOKEN_ENV_VARIABLE);
        String DRIVER = PropertyReader.getProperty("driver");
        DRIVER = DRIVER.replace("***", TOKEN);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(MobileCapabilities.PLATFORM_NAME, PLATFORM);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            mobileCloudApiBuilder().getDeviceBy(UDID);
            mobileCloudApiBuilder()
                    .serial(UDID)
                    .file(app)
                    .installApp(UDID);

            capabilities.setCapability(APP_PACKAGE_TYPE, APP_PACKAGE);
            capabilities.setCapability(APP_ACTIVITY_TYPE, APP_ACTIVITY);
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
