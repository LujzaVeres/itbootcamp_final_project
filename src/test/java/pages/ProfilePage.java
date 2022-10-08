package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{
    protected By profileBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/a[3]");
    protected By nameField = By.id("name");
    protected By phoneField = By.id("phone");
    protected By xBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button");
    protected By cityField = By.id("city");
    protected By city = By.xpath("//*[@id='list-item-163-5']/div/div");
    protected By country = By.id("country");
    protected By twitterField = By.id("urlTwitter");
    protected By gitHubField = By.id("urlGitHub");
    protected By saveBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getProfileBtn() {
        return getDriver().findElement(profileBtn);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getxBtn() {
        return getDriver().findElement(xBtn);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitterField() {
        return getDriver().findElement(twitterField);
    }

    public WebElement getGitHubField() {
        return getDriver().findElement(gitHubField);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public void clickProfileBtn(){
        getProfileBtn().click();
    }

    public void fillCredentials() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.number().digits(10);
        String country = faker.country().name();
        String twitter = "https://" + faker.internet().domainName();
        String gitHub = "https://" + faker.internet().domainName();

        getNameField().click();
        getNameField().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getNameField().sendKeys(name);
        getPhoneField().click();
        getPhoneField().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getPhoneField().sendKeys(phone);
        getxBtn().click();
        getCityField().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        getCity().click();
        getCountry().click();
        getCountry().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getCountry().sendKeys(country);
        getTwitterField().click();
        getTwitterField().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getTwitterField().sendKeys(twitter);
        getGitHubField().click();
        getGitHubField().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getGitHubField().sendKeys(gitHub);
        getSaveBtn().click();
    }
}
