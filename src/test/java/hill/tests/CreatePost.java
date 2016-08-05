package hill.tests;

import hill.pages.*;
import hill.util.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreatePost extends TestNgTestBase {
    private StartPage startPage;
    private AdminPage adminPage;
    private LoginPage loginPage;

    @BeforeTest
    public void initTest(){
        Log.startTestCase("MaimPage");
    }
    @BeforeMethod
    public void initPageObjects() {
        Log.info("Init page object");
        startPage = PageFactory.initElements(driver, StartPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        baseUrl = "https://wordpress.com/";
        driver.get(baseUrl);
    }

    @Test
    public void createPost(){
        startPage.login.click();
        loginPage.loginTo("erlond@ya.ru","HillelCourse");
        adminPage.createButton.click();
        adminPage.fillTitle.sendKeys("AAAA");
        adminPage.fillBody.sendKeys("BBBB");
    }
}
