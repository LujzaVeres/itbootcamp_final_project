package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{
    protected By language = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button");
    protected By esLanguage = By.xpath("//*[@id='list-item-75']");
    protected By enLanguage = By.xpath("//*[@id='list-item-73']");
    protected By frLanguage = By.xpath("//*[@id='list-item-77']");
    protected By actualResultEs = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    protected By actualResultEn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    protected By actualResultFr = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public LocalePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguage() {
        return getDriver().findElement(language);
    }

    public WebElement getEsLanguage() {
        return getDriver().findElement(esLanguage);
    }

    public WebElement getEnLanguage() {
        return getDriver().findElement(enLanguage);
    }

    public WebElement getFrLanguage() {
        return getDriver().findElement(frLanguage);
    }

    public WebElement getActualResultEs() {
        return getDriver().findElement(actualResultEs);
    }

    public WebElement getActualResultEn() {
        return getDriver().findElement(actualResultEn);
    }

    public WebElement getActualResultFr() {
        return getDriver().findElement(actualResultFr);
    }

    public void changeLanguage() {
        getLanguage().click();
    }

    public void languageEs(){
        getEsLanguage().click();
    }

    public void languageEn(){
        getEnLanguage().click();
    }

    public void languageFr(){
        getFrLanguage().click();
    }

}
