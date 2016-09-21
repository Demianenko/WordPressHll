package hill.tests;

import hill.pages.LoginPage;
import hill.pages.StartPage;
import hill.util.DataProviders;
import hill.util.DataSource;
import hill.util.Log;
import hill.util.ReaderFromXLSX;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by user on 06.07.2016.
 */
public class LoginPageTest extends TestNgTestBase {
    private StartPage wordPressStartPage;
    private LoginPage loginPage;

    @BeforeTest
    public void initTest(){
        Log.startTestCase("LoginPage Before Tests");
    }
    @BeforeMethod
    public void initPageObjects() {
        Log.info("Init page object");
        wordPressStartPage = PageFactory.initElements(driver, StartPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get(baseUrl);
        wordPressStartPage.login.click();
    }
    @Test(enabled = false)
    public void thereIsErrorMessage() {
        loginPage.loginTo("a","b");
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }
    @Test(enabled = false)
    public void loginPageHasAHeader() {
        loginPage.wait.until(ExpectedConditions.textToBePresentInElement(loginPage.header,loginPage.title));
        Assert.assertTrue(loginPage.title.equals(loginPage.header.getText()));
    }

    @Test(dataProvider = "new",dataProviderClass = ReaderFromXLSX.class, enabled = false)
    public void loginWithDataProviderInOwnClass(String name, String password) {
        System.out.println(name+"  "+password);
        Log.info("DATA PROVIDER");
        loginPage.loginTo(name,password);
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }

    @Test(dataProvider = "getDataForLoginInToWordPress",dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(xlsx = "src/test/resources/dataForLogin.xlsx")
    public void loginWithDataSourse(String name, String password) {
        System.out.println(name+"  "+password);
        Log.info("DATA PROVIDER");
        loginPage.loginTo(name,password);
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }

    @DataProvider(name = "Addition", parallel = false)
    public static Object[][] credentials() {
        return new Object[][] { {"no","no"},{"NOOO","NOOO"}};
    }
    @Test(dataProvider = "Addition", enabled = false)
    public void testBad(String name, String password) {
        System.out.println(name+"  "+password);
        Log.info("DATA PROVIDER");
        loginPage.loginTo(name,password);
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }
}
