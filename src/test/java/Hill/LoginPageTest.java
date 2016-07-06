package Hill;

import Hill.pages.LoginPage;
import Hill.pages.StartPage;
import Hill.util.Log;
import Hill.util.ReaderFromXLSX;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import Hill.util.ReaderFromXLSX;

/**
 * Created by user on 06.07.2016.
 */
public class LoginPageTest extends TestNgTestBase {
    private StartPage wordPressStartPage;
    private LoginPage loginPage;
    private ReaderFromXLSX read = new ReaderFromXLSX();

    @BeforeTest
    public void initTest(){
        Log.startTestCase("LoginPage");
    }
    @BeforeMethod
    public void initPageObjects() {
        wordPressStartPage = PageFactory.initElements(driver, StartPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get(baseUrl);
        wordPressStartPage.login.click();
    }
    @Test
    public void loginPageHasAHeader() {
        loginPage.wait.until(ExpectedConditions.textToBePresentInElement(loginPage.header,loginPage.title));
        Assert.assertTrue(loginPage.title.equals(loginPage.header.getText()));
    }

    @Test(dataProvider = "LoginPage", enabled = true)
    public void test(String name, String password) {
        loginPage.loginTo(name,password);
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }

    @Test
    public void thereIsErrorMessage() {
        loginPage.loginTo("a","b");
        Assert.assertTrue(loginPage.errorMessage.getText().contains("ОШИБКА"));
    }

    @AfterTest
    public void closeDriver() {
        Log.endTestCase("LoginPage");
        driver.quit();
    }
}
