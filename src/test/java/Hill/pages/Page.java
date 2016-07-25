package hill.pages;

import hill.util.Log;
import org.openqa.selenium.By;
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

    public Page(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 60);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void kill() {
        driver.close();
    }

    public void switchToFrame(String framePath){
        driver.switchTo().frame(driver.findElement(By.xpath(framePath)));
    }
    public void switchToWindow(int numberOfWindow){
        driver.switchTo().window(driver.getWindowHandles().toArray()[numberOfWindow].toString());
    }
    public void moveToElement(WebElement element){
        Log.info("Move to Element " + element.getText());
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

}
