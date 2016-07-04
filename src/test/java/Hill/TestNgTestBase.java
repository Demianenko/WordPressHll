package Hill;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Hill.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import Hill.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    @BeforeMethod
    public void initWebDriver() {
        Log.info("Start driver init...");
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }
}
