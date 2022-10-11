package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{
    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By confirmPassword = By.id("confirmPassword");
    protected By name = By.id("name");
    protected By signMeUp = By.xpath("//*[@id='app']/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    protected By actualResultValidInput = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    protected By actualResultNewInput = By.xpath("//*[@id='app']/div[4]/div/div/div[1]");
    protected By msgBox = By.xpath("//*[@id='app']/div[4]/div/div/div[3]/button/span");

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getSignMeUp() {
        return getDriver().findElement(signMeUp);
    }

    public WebElement getActualResultValidInput() {
        return getDriver().findElement(actualResultValidInput);
    }

    public WebElement getActualResultNewInput() {
        return getDriver().findElement(actualResultNewInput);
    }

    public WebElement getMsgBox() {
        return getDriver().findElement(msgBox);
    }

    public void inputFill(String name, String email, String password, String confirmPassword) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getSignMeUp().click();
    }
}
