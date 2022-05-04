package testPackage;

import Pages.TablePage;
import com.google.common.util.concurrent.Uninterruptibles;
import fuctionalInterface.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class DriverTestStreamsCheckBoxWithPageobjects<Webdriver> {

    private WebDriver driver;
    public TablePage tablePage;

    Predicate<List<WebElement>> allMale   = e -> e.get(1).getText().equalsIgnoreCase("male");
    Predicate<List<WebElement>> allFemale = f -> f.get(1).getText().equalsIgnoreCase("female");
//    Predicate<List<WebElement>> allGender = g -> !g.get(1).getText().isEmpty();
    Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    Predicate<List<WebElement>> allUSA = usa -> usa.get(2).getText().equalsIgnoreCase("USA");
    Predicate<List<WebElement>> allUk = uk -> uk.get(2).getText().equalsIgnoreCase("UK");

    @BeforeTest
    @Parameters("Browser")
    public void setDriver(@Optional("chrome") String Browser) {
        this.driver = DriverFactory.getDriver(Browser);
        this.tablePage = new TablePage(driver);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }


    @Test(dataProvider="searchCriteria")
    public void browserTestRefactored(Predicate<List<WebElement>> searchCriteria)  {
            tablePage.goTo();
            //tablePage.rowSelect(gender);
            tablePage.rowSelect(searchCriteria);


    }

    @DataProvider(name="searchCriteria")
    public Object[][] testData() {

//        return new Object[][] {
//                {"male"},
//                {"female"}
//        };

        return new Object[][] {
                {allMale},
                {allFemale},
                {allGender},
                {allUSA}
        };
    }
}


