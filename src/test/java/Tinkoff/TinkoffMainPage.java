package Tinkoff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TinkoffMainPage {
    private WebDriver driver;
    private WebDriverWait wait;



    @FindBy(linkText = "Платежи")
    private WebElement pay;

    public TinkoffMainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void openLink(){

        driver.get("https://www.tinkoff.ru");
    }

    public void payButtonClick() {
        pay.click();
    }
}