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
    public void adminCitiesUrl() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        Thread.sleep(2000);
        adminCitiesPage.clickCitiesBtn();
        Thread.sleep(2000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/admin/cities"));
        String expectedResult = "LOGOUT";
        WebElement actualRes = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertEquals(actualRes.getText(), expectedResult);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 2)
    public void createCity() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.createCity(adminCitiesPage.fakeCity());
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 3)
    public void editCity() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.editCity();
        Thread.sleep(2000);
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        Thread.sleep(2000);
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 4)
    public void searchCity() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.searchCity();
        Thread.sleep(2000);
        Assert.assertEquals(adminCitiesPage.getFirstCityText().getText(), adminCitiesPage.getSearchedText().getText());
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]"));
        Assert.assertTrue(actualResult.getText().contains(adminCitiesPage.getEditedCity()));
        loginPage.getLogoutBtn().click();
    }

    @Test(priority = 5)
    public void deleteCity() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        Thread.sleep(2000);
        adminCitiesPage.searchCity();
        Thread.sleep(2000);
        WebElement firstRow = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]"));
        driverWait.until(ExpectedConditions.visibilityOf(firstRow));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(actualResult.getText().contains(adminCitiesPage.getEditedCity()));
        adminCitiesPage.deleteCity();
        Thread.sleep(2000);
        adminCitiesPage.finalDelete();
        Thread.sleep(2000);
        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(messageBox.getText().contains("Deleted successfully"));
    }
}
//wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
//        "Saved successfully\nCLOSE"));
//WebElement messageBox = driver.findElement (By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));