package hill.pages;


import hill.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Sample page
 */
public class StartPage extends Page {
    public String title = "WordPress.com";

    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement header;

    @FindBy(xpath = "//*[@class=\"login-link\"]")
    @CacheLookup
    public WebElement login;
    public String loginColorBefore = "rgba(0, 0, 0, 0)";
    public String loginColorAfter = "rgb(0, 170, 220)";


    @FindBy(xpath = "//*[@id=\"top-create-website-button\"]")
    @CacheLookup
    public WebElement topCreateWebsiteButton;
    public String topCreateWebsiteButtonColorBefore = "rgb(30, 140, 190)";
    public String topCreateWebsiteButtonColorAfter = "rgb(0, 170, 220)";

    @FindBy(xpath = "//*[@id=\"apps\"]")
    @CacheLookup
    public WebElement appsBlock;
    public String appsBlockColorBefore = "rgba(30, 140, 190, 1)";
    public String appsBlockColorAfter = "rgba(0, 116, 162, 1)";

    @FindBy(xpath = "//*[@id=\"themes\"]")
    @CacheLookup
    public WebElement themesBlock;
    public String themesBlockColorBefore = "rgba(30, 140, 190, 1)";
    public String themesBlockColorAfter = "rgba(0, 116, 162, 1)";

    @FindBy(xpath = "//*[@id=\"more-features-toggle\"]")
    @CacheLookup
    public WebElement giveMoreButton;
    public String tgiveMoreButtonColorBefore = "rgba(255, 255, 255, 0.74902)";
    public String giveMoreButtonColorAfter = "rgba(255, 255, 255, 1)";

    @FindBy(xpath = "//*[@id=\"bottom-create-website-button\"]")
    @CacheLookup
    public WebElement bottomCreateWebsiteButton;
    public String bottomCreateWebsiteButtonColorBefore = "rgb(30, 140, 190)";
    public String bottomCreateWebsiteButtonColorAfter = "rgb(0, 170, 220)";

    public StartPage(WebDriver webDriver) {
        super(webDriver);
        Log.info("StartPage create");
    }
}
