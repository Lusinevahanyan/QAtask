import Pages.FormPage;
import Pages.HomePage;
import Pages.PracticePage;
import org.junit.Assert;
import org.junit.Test;
import com.github.javafaker.Faker;


public class PracticePageTest extends BaseTest {

    @Test
    public void case1(){
        HomePage homePage = new HomePage(getDriver());
        FormPage formPage = new FormPage(getDriver());
        Faker faker = new Faker();
        PracticePage practicePage = new PracticePage(getDriver());

        homePage.getDriver();

        homePage.ClickOnFormButton();
        Assert.assertEquals(homePage.getCurrentURL(), FORMPAGEURL);

        formPage.navigateToPracticePage();
        Assert.assertEquals(practicePage.getCurrentURL(), PRACTICEPAGEURL);

        String firstName = faker.name().firstName();
        practicePage.typeFirstName(firstName);
        String lastName = faker.name().lastName();
        practicePage.typeLastName(lastName);
        practicePage.clickRadioButtonFemale();
        String phoneNumber = faker.number().digits(10);
        practicePage.typeMobile(phoneNumber);
        practicePage.clickSubminButton();
        practicePage.waitUntilModalAppear();

        Assert.assertEquals(practicePage.getStudentFullName(), firstName + " " + lastName);
        Assert.assertEquals(practicePage.getStudentGender(), "Female");
        Assert.assertEquals(practicePage.getStudentPhoneNumber(), phoneNumber);

    }

    @Test
    public void case2(){
        HomePage homePage = new HomePage(getDriver());
        FormPage formPage = new FormPage(getDriver());
        PracticePage practicePage = new PracticePage(getDriver());

        homePage.getDriver();
        homePage.ClickOnFormButton();
        Assert.assertEquals(homePage.getCurrentURL(), FORMPAGEURL);

        formPage.navigateToPracticePage();
        Assert.assertEquals(practicePage.getCurrentURL(), PRACTICEPAGEURL);

        String defaultFirstNameFieldBorderColor = practicePage.getFirstNameFieldBorderColor();
        String defaultLastNameFieldBorderColor = practicePage.getLastNameFieldBorderColor();
        String defaultGenderRadioBorderColor = practicePage.getGenderRadioButtonBorderColor();
        String defaultMobileFieldBorderColor = practicePage.getMobileFieldBorderColor();

        practicePage.clickSubminButton();

        Assert.assertNotSame(defaultFirstNameFieldBorderColor,practicePage.getFirstNameFieldBorderColor());
        Assert.assertNotSame(defaultLastNameFieldBorderColor,practicePage.getLastNameFieldBorderColor());
        Assert.assertNotSame(defaultGenderRadioBorderColor,practicePage.getGenderRadioButtonBorderColor());
        Assert.assertNotSame(defaultMobileFieldBorderColor,practicePage.getMobileFieldBorderColor());

    }
}
