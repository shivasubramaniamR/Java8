package testPackage;

import fuctionalInterface.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DriverTestStreams<Webdriver> {

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

    @Test(enabled = false)
    public void browserTest() {

        this.driver.get("https://www.google.co.in");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .filter(blank -> blank.getText().strip().length()!=0)
//                .filter(containsS -> !containsS.getText().toLowerCase().contains("s"))
                .filter(containsS -> containsS.getText().toLowerCase().contains("s"))
                .map(conversion -> conversion.getText().toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void browserTestRefactored() {

        this.driver.get("https://www.google.co.in");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(e -> e.length()!=0)
                .filter(f-> !f.toLowerCase().contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
