package fuctionalInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    //"D:\Technology\Tools\drivers\firefox\geckodriver.exe"
    //"D:\Technology\Tools\drivers\chrome\chromedriver.exe"
    
    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver","D:\\Technology\\Tools\\drivers\\chrome\\chromedriver.exe");
        return new ChromeDriver();
    };

    private  static final Supplier<WebDriver> firefoxsupplier = () -> {
        System.setProperty("webdriver.gecko.driver","D:\\Technology\\Tools\\drivers\\firefox\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",chromeSupplier);
        MAP.put("firefox",firefoxsupplier);
    }

    public static WebDriver getDriver(String Browser) {
        return MAP.get(Browser).get();
    }
}
