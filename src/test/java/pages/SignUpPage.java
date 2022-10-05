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
    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
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

    public void inputFill(String name, String email, String password, String confirmPassword) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getSignMeUp().click();
    }

//    public boolean validCredentials() {
//        WebElement error = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
//        inputFill ("Test Test", "admin@admin.com", "123654", "123654");
//        if (error.equals("User does not exists")){
//            return true;
//        } else {
//            return false;
//        }
//    }
}
