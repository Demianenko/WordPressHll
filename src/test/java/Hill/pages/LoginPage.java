package Hill.pages;


import Hill.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Sega on 03.07.2016.
 */
public class LoginPage extends Page {
    public String title = "WordPress.com";

    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement header;

    @FindBy(xpath = "//*[@id=\"user_login\"]")
    @CacheLookup
    public WebElement loginField;

    @FindBy(xpath = "//*[@id=\"user_pass\"]")
    @CacheLookup
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"rememberme\"]")
    @CacheLookup
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//*[@id=\"wp-submit\"]")
    @CacheLookup
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"login_error\"]")
    @CacheLookup
    public WebElement errorMessage;

    public void loginTo(String name, String password) {
        Log.info("Start LoginTo");
        loginField.clear();
        Log.info("Set Name");
        loginField.sendKeys(name);
        passwordField.clear();
        Log.info("Set password");
        passwordField.sendKeys(password);
        Log.info("Click button");
        submitButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        Log.info("LoginPage create");
    }

}
