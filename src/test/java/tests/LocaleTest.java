package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{

    @Test (priority = 1)
    public void changeLanguageEs() throws InterruptedException {
        localePage.changeLanguage();
        localePage.languageEs();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Página de aterrizaje");

    }

    @Test (priority = 2)
    public void changeLanguageEn() throws InterruptedException {
        localePage.changeLanguage();
        localePage.languageEn();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Landing");
    }

    @Test(priority = 3)
    public void changeLanguageFr() throws InterruptedException {
        localePage.changeLanguage();
        localePage.languageFr();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Page d'atterrissage");

        }
    }
