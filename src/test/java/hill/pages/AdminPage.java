package hill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sega on 26.07.16.
 */
public class AdminPage extends Page {
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class=\"gridicon gridicons-create \"]")
    @CacheLookup
    public WebElement createButton;

    @FindBy(xpath = "//*[@class=\"editor-title\"]")
    @CacheLookup
    public WebElement fillTitle;

    @FindBy(xpath = "//*[@id=\"tinymce\"]")
    @CacheLookup
    public WebElement fillBody;


}
