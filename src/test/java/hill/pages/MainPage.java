package hill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by user on 23.07.2016.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String title = "https://autocource.wordpress.com/";

    @FindBy(xpath = "//*[@id=\"post-2\"]")
    @CacheLookup
    public WebElement post;

    @FindBy(xpath = "//article//a")
    @CacheLookup
    public List<WebElement> postsList;


   // post-likes-widget jetpack-likes-widget
}
