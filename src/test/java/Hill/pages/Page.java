package Hill.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    protected WebDriver driver;
    public WebDriverWait wait;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 30);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

}
