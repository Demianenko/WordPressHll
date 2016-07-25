package hill.tests;

import com.sun.jersey.api.client.WebResource;
import hill.pages.LoginPage;
import hill.pages.MainPage;
import hill.pages.PostPage;
import hill.util.Log;
import net.thucydides.core.annotations.findby.By;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by user on 23.07.2016.
 */
public class LikesFunk extends TestNgTestBase {
    private MainPage mainPage;
    private PostPage postPage;
    private LoginPage loginPage;

    @BeforeTest
    public void initTest(){
        Log.startTestCase("MaimPage");
    }
    @BeforeMethod
    public void initPageObjects() {
        Log.info("Init page object");
        mainPage = PageFactory.initElements(driver, MainPage.class);
        postPage = PageFactory.initElements(driver, PostPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        baseUrl = "https://autocource.wordpress.com/";
        //driver.get("http://UserName:Password@Example.com");
        driver.get("http://erlond@ya.ru:HillelCourse@autocource.wordpress.com/");
        //driver.get(baseUrl);
    }

    @Test(enabled = false)
    public void title(){
        System.out.println(mainPage.getTitle());
    }

    @Test
    public void checkLikes() throws InterruptedException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts/4/likes/";
        Assert.assertEquals(foundReturn(urlApi,pathApi,"found"),"0");
        mainPage.postsList.get(0).click();
        postPage.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(postPage.likeFrame)));
        postPage.likeButton.click();
        postPage.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        postPage.switchToWindow(1);
        loginPage.loginTo("erlond@ya.ru","HillelCourse");
        Thread.sleep(2000);
        Assert.assertEquals(foundReturn(urlApi,pathApi,"found"),"1");
        Thread.sleep(2000);
        postPage.switchToWindow(0);
        postPage.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(postPage.likeFrame)));
        postPage.likeButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(foundReturn(urlApi,pathApi,"found"),"0");
    }

    @Test(enabled=false)
    public void test3() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts";
        Assert.assertTrue(foundReturn(urlApi,pathApi,"posts").contains("test"));
    }
    @Test(enabled=false)
    public void test4() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts/4/likes/";
        System.out.println(foundReturn(urlApi,pathApi,"found") + " before click");
    }

    private String foundReturn(String url, String puth, String value){
        String actual = "";
        try{
            WebResource webResource = client().resource(url);
            JSONObject json = webResource.path(puth).get(JSONObject.class);
            actual = json.get(value).toString();
            System.out.println(actual);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return actual;
    }
}
