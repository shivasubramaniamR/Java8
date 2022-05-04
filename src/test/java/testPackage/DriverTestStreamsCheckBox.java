package testPackage;

import com.google.common.util.concurrent.Uninterruptibles;
import fuctionalInterface.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DriverTestStreamsCheckBox<Webdriver> {

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


    @Test(dataProvider="gender")
    public void browserTestRefactored(String gender) throws InterruptedException {

        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(ll->ll.size()==4)
                .filter(e -> e.get(1).getText().equalsIgnoreCase(gender))
                .map(list -> list.get(3))
                .map(check -> check.findElement(By.tagName("input")))
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @DataProvider(name="gender")
    public Object[][] testData() {

        return new Object[][] {
                {"male"},
                {"female"}
        };
    }
}


