package hill.tests;

import hill.pages.LoginPage;
import hill.util.Log;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import hill.pages.StartPage;

public class StartPageTest extends TestNgTestBase {

    private StartPage wordPressStartPage;
    private LoginPage loginPage;

    @BeforeTest
    public void initTest(){
        Log.startTestCase("WordPress");
    }
    @BeforeMethod
    public void initPageObjects() {
        wordPressStartPage = PageFactory.initElements(driver, StartPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get(baseUrl);
    }

    @Test
    public void startPageHasAHeader() {
        Assert.assertTrue(wordPressStartPage.title.equals(wordPressStartPage.header.getText()));
    }

    @Test(enabled = false)
    public void startPageLoginColor() {
        Assert.assertTrue(wordPressStartPage.login.getCssValue("background").contains(wordPressStartPage.loginColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.login);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.login,"background",wordPressStartPage.loginColorAfter));
        Assert.assertTrue(wordPressStartPage.login.getCssValue("background").contains(wordPressStartPage.loginColorAfter));
    }
    @Test(enabled = true)
    public void topCreateWebsiteButtonColor(){
        Assert.assertTrue(wordPressStartPage.topCreateWebsiteButton.getCssValue("background").contains(wordPressStartPage.topCreateWebsiteButtonColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.topCreateWebsiteButton);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.topCreateWebsiteButton,"background",wordPressStartPage.topCreateWebsiteButtonColorAfter));
        Assert.assertTrue(wordPressStartPage.topCreateWebsiteButton.getCssValue("background").contains(wordPressStartPage.topCreateWebsiteButtonColorAfter));
    }

    @Test(enabled = true)
    public void appsBlockColor() throws InterruptedException {
        Assert.assertTrue(wordPressStartPage.appsBlock.getCssValue("color").contains(wordPressStartPage.appsBlockColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.appsBlock);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.appsBlock,"color",wordPressStartPage.appsBlockColorAfter));
        Assert.assertTrue(wordPressStartPage.appsBlock.getCssValue("color").contains(wordPressStartPage.appsBlockColorAfter));
    }
    @Test(enabled = true)
    public void themesBlockColor() {
        Assert.assertTrue(wordPressStartPage.themesBlock.getCssValue("color").contains(wordPressStartPage.themesBlockColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.themesBlock);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.themesBlock,"color",wordPressStartPage.themesBlockColorAfter));
        Assert.assertTrue(wordPressStartPage.themesBlock.getCssValue("color").contains(wordPressStartPage.themesBlockColorAfter));
    }

    @Test(enabled = true)
    public void giveMoreButtonColor(){
        Assert.assertTrue(wordPressStartPage.giveMoreButton.getCssValue("color").contains(wordPressStartPage.tgiveMoreButtonColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.giveMoreButton);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.giveMoreButton,"color",wordPressStartPage.giveMoreButtonColorAfter));
        Assert.assertTrue(wordPressStartPage.giveMoreButton.getCssValue("color").contains(wordPressStartPage.giveMoreButtonColorAfter));
    }

    @Test(enabled = true)
    public void bottomCreateWebsiteButtonColor() throws InterruptedException {
        Assert.assertTrue(wordPressStartPage.bottomCreateWebsiteButton.getCssValue("background").contains(wordPressStartPage.bottomCreateWebsiteButtonColorBefore));
        wordPressStartPage.moveToElement(wordPressStartPage.bottomCreateWebsiteButton);
        wordPressStartPage.wait.until(ExpectedConditions.attributeContains(wordPressStartPage.bottomCreateWebsiteButton,"background",wordPressStartPage.bottomCreateWebsiteButtonColorAfter));
        Assert.assertTrue(wordPressStartPage.bottomCreateWebsiteButton.getCssValue("background").contains(wordPressStartPage.bottomCreateWebsiteButtonColorAfter));
    }
    @Test
    public void loginPageHasAHeader() {
        wordPressStartPage.login.click();
        loginPage.wait.until(ExpectedConditions.textToBePresentInElement(loginPage.header,loginPage.title));
        Assert.assertTrue(loginPage.title.equals(loginPage.header.getText()));
    }
    @AfterTest
    public void closeDriver() {
        Log.endTestCase("WordPress");
        driver.quit();
    }


}
