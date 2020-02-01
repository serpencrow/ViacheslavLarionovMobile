package hw3;


import hw3.setup.DriverSetup;
import hw3.setup.PropertyFile;
import hw3.setup.PropertyReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks extends DriverSetup {

    @BeforeSuite(groups = {"native"})
    void setUpNative() throws Exception {
        PropertyReader.setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"web"})
    void setUpWeb() throws Exception {
        PropertyReader.setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @AfterSuite(groups = {"native", "web"})
    public void tearDown() throws Exception {
        getDriver().quit();
    }
}
