package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        homePage.loginUrl();
        wait.until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }

    @Test
    public void input() {
        homePage.loginUrl();
        String actualEmail = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");
        String actualPassword = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualPassword, "password");
    }

    @Test
    public void invalidUsername() {
        homePage.loginUrl();
        loginPage.invalidEmail(fakerClass.getEmail(), "12345");
        Assert.assertEquals(loginPage.getActualResultInvalidUser().getText(), "User does not exists");
        login();
    }

    @Test
    public void invalidPassword() {
        homePage.loginUrl();
        loginPage.invalidPassword("admin@admin.com", fakerClass.getPassword());
        Assert.assertEquals(loginPage.getActualResultInvalidPass().getText(), "Wrong password");
        login();
    }

    @Test
    public void validCredentials() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        wait.until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/home"));
    }

    @Test
    public void logOutBtn() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        String expectedResult = "LOGOUT";
        WebElement actualResult = loginPage.getLogoutBtn();
        Assert.assertEquals(actualResult.getText(), expectedResult);
        homePage.ifLoggedInLogout();
        String actualRes = driver.getCurrentUrl();
        Assert.assertTrue(actualRes.contains("login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
