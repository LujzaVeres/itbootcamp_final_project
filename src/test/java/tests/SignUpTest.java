package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpUrl() {
        homePage.clickSignUp();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("signup"));
    }

    @Test
    public void input() {
        homePage.clickSignUp();
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");

        String actualPassword = signUpPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualPassword, "password");

        String actualConfirmPassword = signUpPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualConfirmPassword, "password");
    }

    @Test (dependsOnMethods = {"input"})
    public void validInput(){
        homePage.clickSignUp();
        signUpPage.inputFill("Test Test", "admin@admin.com", "123654", "123654");
        Assert.assertEquals(signUpPage.getActualResultValidInput().getText(), "E-mail already exists");
        signUpUrl();
    }

    @Test(dependsOnMethods = {"input", "validInput"})
    public void newInput() {
        homePage.clickSignUp();
        signUpPage.inputFill("Lujza Veres", fakerClass.getEmail(), "12346", "12346");
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        Assert.assertEquals(signUpPage.getActualResultNewInput().getText(), "IMPORTANT: Verify your account");
        signUpPage.getMsgBox();
    }
}