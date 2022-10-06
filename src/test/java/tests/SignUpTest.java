package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest{

    @Test (priority = 1)
    public void signUpUrl() throws InterruptedException {
        homePage.clickSignUp();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("signup"));
    }

    @Test (priority = 2)
    public void input() throws InterruptedException {
        homePage.clickSignUp();
        Thread.sleep(3000);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualPassword = signUpPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualPassword, "password");

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualConfirmPassword = signUpPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualConfirmPassword, "password");

    }
    @Test (priority = 3)
    public void validInput() throws InterruptedException {
        homePage.clickSignUp();
        signUpPage.inputFill("Test Test", "admin@admin.com", "123654", "123654");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "E-mail already exists");
        signUpUrl();
    }

    @Test (priority = 4)
    public void newInput() throws InterruptedException {
        homePage.clickSignUp();
        signUpPage.inputFill("Lujza Veres", signUpPage.getFaker().internet().emailAddress(), "12346", "12346");
        Thread.sleep(5000);
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div/div[1]"));
        Assert.assertEquals(actualResult.getText(), "IMPORTANT: Verify your account");
    }
}//etWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
