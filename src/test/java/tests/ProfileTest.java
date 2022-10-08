package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfile() throws InterruptedException {
        homePage.loginUrl();
        loginPage.inputFill("admin@admin.com", "12345");
        profilePage.clickProfileBtn();
        profilePage.fillCredentials();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Profile saved successfuly"));
        String actualName = profilePage.getNameField().getAttribute("value");
        Assert.assertTrue(actualName.contains(profilePage.getNameField().getText()));
        String actualPhone = profilePage.getPhoneField().getAttribute("value");
        Assert.assertTrue(actualPhone.contains(profilePage.getPhoneField().getText()));
        String actualCity = profilePage.getCityField().getAttribute("value");
        Assert.assertTrue(actualCity.contains(profilePage.getCityField().getText()));
        String actualCountry = profilePage.getCountry().getAttribute("value");
        Assert.assertTrue(actualCountry.contains(profilePage.getCountry().getText()));
        String actualTwitter = profilePage.getTwitterField().getAttribute("value");
        Assert.assertTrue(actualTwitter.contains(profilePage.getTwitterField().getText()));
        String actualGitHub = profilePage.getGitHubField().getAttribute("value");
        Assert.assertTrue(actualGitHub.contains(profilePage.getGitHubField().getText()));

    }
}
