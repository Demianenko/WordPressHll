package hill.tests;

import hill.pages.AdminPage;
import hill.pages.LoginPage;
import hill.pages.StartPage;
import hill.util.Log;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        adminPage.wait.until(ExpectedConditions.elementToBeClickable(adminPage.createButton));
        adminPage.createButton.click();
        adminPage.moveToElement(adminPage.fillTitle);
        adminPage.fillTitle.click();
        adminPage.fillTitle.sendKeys("AAAA");
        adminPage.switchToFrame(adminPage.frameForBody);
        adminPage.fillBody.sendKeys("BBBB");
        driver.switchTo().defaultContent();
        adminPage.previewButton.click();
        /*
        System.out.println(driver.findElements(By.xpath("//*[@class=\"web-preview is-visible is-tablet is-loaded\"]")).size());
        System.out.println(driver.findElements(By.xpath("//*[@class=\"web-preview__frame\"]")).size());
        adminPage.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(adminPage.frameWebPreview));
        System.out.println(driver.findElements(By.xpath("//*[@class=\"entry-content\"]")).size());
        Assert.assertEquals(adminPage.entryContent.getText(),"BBBB");

        driver.switchTo().defaultContent();
        adminPage.wait.until(ExpectedConditions.visibilityOf(adminPage.sitBranding));
        Assert.assertEquals(adminPage.sitBranding.getText(),"AutoCource");
        System.out.println("Nooo");
        */
    }
}
