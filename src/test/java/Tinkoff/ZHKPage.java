package Tinkoff;

;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class ZHKPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@aria-label='Москве']")
    private WebElement regionName;

    @FindBy(linkText = "ЖКУ-Москва")
    private WebElement zkuMoscow;

    @FindBy(xpath = "//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]")
    private WebElement zkuMoscowPay;

    @FindBy(xpath = "//button")
    private WebElement payButton;

    public ZHKPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getRegionName(){

        return regionName.getText();
    }

    public void zkuMoscowButtonClick() {
        zkuMoscow.click();

    }

    public void zkuMoscowPayClick(){
        zkuMoscowPay.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//button")));
    }

    public void payButtonClick(){
        payButton.click();
    }



}
