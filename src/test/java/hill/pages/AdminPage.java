package hill.pages;

import hill.util.Log;
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
        Log.info("AdminPage create");
    }
    @FindBy(xpath = "//*[@class=\"gridicon gridicons-create \"]")
    @CacheLookup
    public WebElement createButton;

    @FindBy(xpath = "//*[@class=\"textarea-autosize editor-title__input\"]")
    @CacheLookup
    public WebElement fillTitle;

    @FindBy(xpath = "//*[@id=\"tinymce\"]")
    @CacheLookup
    public WebElement fillBody;

    @FindBy(xpath = "//*[@class=\"editor-ground-control__preview-button button\"]")
    @CacheLookup
    public WebElement previewButton;

    @FindBy(xpath = "//*[@class=\"entry-content\"]")
    @CacheLookup
    public WebElement entryContent;

    @FindBy(xpath = "//*[@class=\"site-branding\"]")
    @CacheLookup
    public WebElement sitBranding;




    public String frameForBody  = "//*[@id=\"tinymce-1_ifr\"]";
    public String frameWebPreview = "//*[@class=\"web-preview__frame\"]";;

}
