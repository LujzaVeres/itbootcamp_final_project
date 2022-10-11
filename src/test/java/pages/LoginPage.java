package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By loginBtn = By.xpath("//*[@id='app']/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    protected By logoutBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span");
    protected By actualResultInvalidUser = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    protected By actualResultInvalidPass = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public WebElement getActualResultInvalidUser() {
        return getDriver().findElement(actualResultInvalidUser);
    }

    public WebElement getActualResultInvalidPass() {
        return getDriver().findElement(actualResultInvalidPass);
    }

    public void inputFill(String email, String password) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }

    public void invalidEmail(String name, String password) {
        inputFill(name, password);
    }

    public void invalidPassword(String name, String password) {
        inputFill(name, password);
    }
}

