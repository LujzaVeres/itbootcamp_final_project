package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test (priority = 1)
    public void login() {
        homePage.loginUrl();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }

    @Test (priority = 2)
    public void input() {
        homePage.loginUrl();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualEmail = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualPassword = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualPassword, "password");
    }

    @Test (priority = 3)
    public void invalidUsername() {
        homePage.loginUrl();
        loginPage.invalidEmail();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "User does not exists");
        login();
    }

    @Test (priority = 4)
    public void invalidPassword() {
        homePage.loginUrl();
        loginPage.invalidPassword();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "Wrong password");
        login();
    }

    @Test (priority = 5)
    public void validCredentials() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/home"));
    }

    @Test (priority = 6)
    public void logOutBtn() {
        homePage.loginUrl();
        String expectedResult = "LOGOUT";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
        loginPage.getLogoutBtn().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualRes = driver.getCurrentUrl();
        Assert.assertTrue(actualRes.contains("login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
