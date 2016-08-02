package hill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 23.07.2016.
 */
public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);
    }
    public String likeFrame = "//*[@class=\"post-likes-widget jetpack-likes-widget\"]";

    @FindBy(xpath = "//*[@id=\"target\"]//a/span")
    public WebElement likeButton;

}
