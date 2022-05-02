package testPackage;

import fuctionalInterface.DriverFactory;
import fuctionalInterface.PredicateRules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DriverTestPredicate<Webdriver> {

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

    @Test(enabled=true)
    public void browserTest() {

        this.driver.get("https://www.google.co.in");
        //this.driver.findElements(By.tagName("a")).forEach( e -> System.out.println(e.getText()));

        List<WebElement> ele=this.driver.findElements(By.tagName("a"));

//        Predicate<WebElement> isBlank = e -> e.getText().trim().length() ==0;
//        Predicate<WebElement> removeLowerCaseS = s -> s.getText().contains("s");
//        Predicate<WebElement> removeUpperCaseS = S -> S.getText().contains("S");

        //Predicate<WebElement>  removeS = text -> text.getText().replaceAll("[s]","");

        System.out.println(ele.size());
        ele.forEach(e -> System.out.println(e.getText()));
//        ele.removeIf(isBlank.or(removeLowerCaseS).or(removeUpperCaseS));
       // PredicateRules.getList().forEach(rule -> ele.removeIf(rule));
        PredicateRules.getList().forEach(ele::removeIf);

        System.out.println(ele.size());
        ele.forEach(e -> System.out.println(e.getText()));

    }

    @Test(enabled = false)
    public void StringRemoveFromList() {
        List<String> names = new ArrayList<>();
        names.add("sam");
        names.add("gadam");
        names.add("dfdfdsam");
        names.add("amfdfdfdfdS");
        names.add("sam");


        Predicate<String> p = t -> t.contains("s");
        Predicate<String> p1 = t -> t.contains("S");



        System.out.println(names);
        names.removeIf(p.or(p1));

        System.out.println(names);

    }
}
