package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AdminCitiesTest extends BaseTest {

    @Test(priority = 1)
    public void adminCitiesUrl() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        adminCitiesPage.clickCitiesBtn();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/admin/cities"));
        String expectedResult = "LOGOUT";
        WebElement actualRes = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertEquals(actualRes.getText(), expectedResult);
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 2)
    public void createCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.createCity(adminCitiesPage.fakeCity());
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 3)
    public void editCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.editCity();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 4)
    public void searchCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.searchCity();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertEquals(adminCitiesPage.getFirstCityText().getText(), adminCitiesPage.getSearchedText().getText());
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]"));
        Assert.assertTrue(actualResult.getText().contains(adminCitiesPage.getEditedCity()));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 5)
    public void deleteCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        adminCitiesPage.searchCity();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstRow = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]"));
        driverWait.until(ExpectedConditions.visibilityOf(firstRow));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(actualResult.getText().contains(adminCitiesPage.getEditedCity()));
        adminCitiesPage.deleteCity();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        adminCitiesPage.finalDelete();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(messageBox.getText().contains("Deleted successfully"));
        loginPage.getLogoutBtn().click();
    }
}
