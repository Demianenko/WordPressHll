package Hill.pages;


import Hill.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Sample page
 */
public class StartPage extends Page {
    public String title = "WordPress.com";

    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement header;

    @FindBy(xpath = "//*[@class=\"click-wpcom-login\"]")
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
