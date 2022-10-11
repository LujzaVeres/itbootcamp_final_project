package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FakerClass extends BasePage {
    protected Faker faker = new Faker();
    protected final String email = faker.internet().emailAddress();
    protected final String password = faker.internet().password();
    protected final String confirmPassword = faker.internet().password();
    private final String city = faker.address().city();
    private final String editedCity = city + " - edited";
    private final String name = faker.name().fullName();
    private final String phone = faker.number().digits(10);
    private final String country = faker.country().name();
    private final String twitter = "https://" + faker.internet().domainName();
    private final String gitHub = "https://" + faker.internet().domainName();

    public FakerClass(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCity() {
        return city;
    }

    public String getEditedCity() {
        return editedCity;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGitHub() {
        return gitHub;
    }
}
