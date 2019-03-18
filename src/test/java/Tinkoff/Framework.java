package Tinkoff;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Framework {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException {

        URL chromeDriverUrl = new URL("http://localhost:9515");
        driver = new RemoteWebDriver(chromeDriverUrl, new ChromeOptions()); // открываем хром
        System.out.println("Загружено");
        driver.manage().window().maximize(); // разворачиваем окно
    }

    @After
    public void close() {
        driver.quit();
    }

}
