package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    protected By login =  By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[3]/span");
    protected By signUp =  By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[4]/span");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
    }

    public WebElement getSignUp() {
        return getDriver().findElement(signUp);
    }

    public void loginUrl() {
        getLogin().click();
    }

    public void clickSignUp(){
        getSignUp().click();
    }

    public void ifLoggedInLogout(){
        WebElement logoutBtn = getDriver().findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logoutBtn.isDisplayed()){
            logoutBtn.click();
        }
    }
}


