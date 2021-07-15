package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By formDiv = By.xpath("//div/h5[text()='Forms']");

    public HomePage getDriver() {
        driver.get(HOMEPAGEURL);
        BasePage.waitForPageFullLoaded();
        return new HomePage(driver);
    }
    public FormPage ClickOnFormButton(){
        driver.findElement(formDiv).click();
        return new FormPage(driver);
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }


}
