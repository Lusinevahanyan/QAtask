package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        super(driver);
    }

    private By menuItemForm = By.xpath("//div[@class='accordion']/div[2]");
    private By menuItemPracticeForm = By.xpath("//span[text()= 'Practice Form']");

    public boolean practiceFormItemIsDisplayed(){
        return driver.findElement(menuItemPracticeForm).isDisplayed();
    }
    public FormPage clickOnMenuItemForm(){
        driver.findElement(menuItemForm).click();
        return new FormPage(driver);
    }
    public PracticePage clickOnMenuItemPracticeForm(){
        driver.findElement(menuItemPracticeForm).click();
        return new PracticePage(driver);
    }

    public PracticePage navigateToPracticePage(){
        if (practiceFormItemIsDisplayed()){
            clickOnMenuItemPracticeForm();
        }
        else clickOnMenuItemForm();
        clickOnMenuItemPracticeForm();
        return new PracticePage(driver);
    }

}
