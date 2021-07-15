package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PracticePage extends BasePage {
    public PracticePage(WebDriver driver) {
        super(driver);
    }
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By genderRadioButtonFemale = By.xpath("//*[@id='genterWrapper']/div[2]/div[2]/label");
    //private By genderRadioButtonFemale = By.id("gender-radio-2");
    private By mobileField = By.id("userNumber");
    private By submitButton = By.xpath("//*[@id='submit']");
    //--------Modal content locators-----------------
    private By modalWindow = By.id("example-modal-sizes-title-lg");
    private By studentFullName = By.xpath("//tbody/tr[1]/td[2]");
    private By studentGender = By.xpath("//table/tbody/tr[3]/td[2]");
    private By studentMobile = By.xpath("//table/tbody/tr[4]/td[2]");

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public PracticePage typeFirstName(String name){
        driver.findElement(firstNameField).sendKeys(name);
        return new PracticePage(driver);
    }

    public PracticePage typeLastName(String name){
        driver.findElement(lastNameField).sendKeys(name);
        return new PracticePage(driver);
    }

    public PracticePage clickRadioButtonFemale(){
        driver.findElement(genderRadioButtonFemale).click();
        return new PracticePage(driver);
    }
    public PracticePage typeMobile(String number){
        driver.findElement(mobileField).sendKeys(number);
        return new PracticePage(driver);
    }
    public PracticePage clickSubminButton() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(submitButton).click();
        return new PracticePage(driver);
    }
    public boolean modalWindowIsDisplayed(){
        return driver.findElement(modalWindow).isDisplayed();
    }

    public String getStudentFullName (){
       return driver.findElement(studentFullName).getText();
    }

    public PracticePage waitUntilModalAppear(){
        BasePage.waitForElementToAppear(modalWindow);
        return new PracticePage(driver);
    }

    public String getStudentGender(){
        return driver.findElement(studentGender).getText();
    }
    public String getStudentPhoneNumber(){
        return driver.findElement(studentMobile).getText();
    }

    
    public String getFirstNameFieldBorderColor(){
        return driver.findElement(firstNameField).getCssValue("border-color");
    }
    public String getLastNameFieldBorderColor(){
        return driver.findElement(lastNameField).getCssValue("border-color");
    }
    public String getGenderRadioButtonBorderColor(){
        return driver.findElement(firstNameField).getCssValue("border-color");
    }
    public String getMobileFieldBorderColor(){
        return driver.findElement(firstNameField).getCssValue("border-color");
    }


}
