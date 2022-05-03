package testPackage;

import fuctionalInterface.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverTest<Webdriver> {

    private WebDriver driver;

    @BeforeTest
    @Parameters("Browser")
    public void setDriver(@Optional("chrome") String Browser) {
        this.driver = DriverFactory.getDriver(Browser);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @Test
    public void browserTest() {
        this.driver.get("https://www.google.co.in");
    }
}
