package Tinkoff;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[text()='ЖКХ']")
    private WebElement zkh;


    public PayPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void zkhButtonClick(){
        zkh.click();
    }



}