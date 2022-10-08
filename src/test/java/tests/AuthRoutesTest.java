package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

    @Test(priority = 1)
    public void forbidsHomeUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test(priority = 2)
    public void forbidsProfileUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test(priority = 3)
    public void forbidsAdminCities() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test(priority = 4)
    public void forbidsAdminUsers(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }
}
