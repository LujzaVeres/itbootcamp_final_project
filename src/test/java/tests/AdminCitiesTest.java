package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @Test
    public void adminCitiesUrl() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/admin/cities"));
        String expectedResult = "LOGOUT";
        Assert.assertEquals(adminCitiesPage.getActualRes().getText(), expectedResult);
        homePage.ifLoggedInLogout();
    }

    @Test
    public void createCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.createCity(fakerClass.getCity());
        adminCitiesPage.saveMsg();
        homePage.ifLoggedInLogout();
    }

    @Test (dependsOnMethods = {"createCity"})
    public void editCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.editCity(fakerClass.getEditedCity());
        adminCitiesPage.saveMsg();
        homePage.ifLoggedInLogout();
    }

    @Test (dependsOnMethods = {"createCity", "editCity"})
    public void searchCity() {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.searchCity(fakerClass.getEditedCity());
        Assert.assertEquals(adminCitiesPage.getFirstCityText().getText(), adminCitiesPage.getSearchedText().getText());
        Assert.assertTrue(adminCitiesPage.getActualResult().getText().contains(fakerClass.getEditedCity()));
        homePage.ifLoggedInLogout();
    }

    @Test (dependsOnMethods = {"createCity", "editCity", "searchCity"})
    public void deleteCity() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        adminCitiesPage.clickAdminBtn();
        adminCitiesPage.clickCitiesBtn();
        adminCitiesPage.searchCity(fakerClass.getEditedCity());
        wait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getFirstRow()));
        Assert.assertTrue(adminCitiesPage.getActualResultForDeletedCity().getText().contains(fakerClass.getEditedCity()));
        adminCitiesPage.deleteCity();
        adminCitiesPage.finalDelete();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.getMessageBox().getText().contains("Deleted successfully"));
        homePage.ifLoggedInLogout();
    }
}
