package testPackage;

import fuctionalInterface.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverTestConsumer<Webdriver> {

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
        this.driver.findElements(By.tagName("a")).forEach( e -> System.out.println(e.getText()));
    }
}
