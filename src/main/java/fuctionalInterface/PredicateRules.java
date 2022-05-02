package fuctionalInterface;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateRules {

    public static Predicate<WebElement> isBlank = e -> e.getText().trim().length() ==0;
    public static Predicate<WebElement> removeLowerCaseS = s -> s.getText().contains("s");
    public static Predicate<WebElement> removeUpperCaseS = S -> S.getText().contains("S");

    public static List<Predicate<WebElement>> getList() {
        List<Predicate<WebElement>> list = new ArrayList<>();
        list.add(isBlank);
        list.add(removeLowerCaseS);
        list.add(removeUpperCaseS);
        return list;
    }


}
