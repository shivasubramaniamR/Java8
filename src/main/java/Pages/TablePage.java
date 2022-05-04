package Pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class TablePage {

    private final WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
    }

    public void rowSelect(Predicate<List<WebElement>> searchCriteria){
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(ll->ll.size()==4)
               //.filter(e -> e.get(1).getText().equalsIgnoreCase(gender))
                .filter(searchCriteria)
                .map(list -> list.get(3))
                .map(check -> check.findElement(By.tagName("input")))
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }
}
