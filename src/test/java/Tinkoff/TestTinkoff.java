package Tinkoff;

//import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;

public class TestTinkoff extends Framework {

    //private RemoteWebDriver driver;
//    @Before
//    public void setUP() throws MalformedURLException {
//        URL chromeDriverUrl = new URL("http://localhost:9515");
//        driver = new RemoteWebDriver(chromeDriverUrl, new ChromeOptions()); // открываем хром

    //    }
    @Test
    public void testTinkoff() {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ZHKPage zkhPage = PageFactory.initElements(driver, ZHKPage.class);
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);

        System.out.println("Открытие сайта");
        mainPage.openLink();

        System.out.println("Нажать Платежи");
        mainPage.payButtonClick();
        System.out.println("Нажать ЖКХ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("//body/div[@class='application']/div[@data-qa-file='UIFormAppPopup']/div[@class='PlatformLayout__layout_1an9n ui-layout']/div[@class='PlatformLayout__layoutPage_1e7Pm']/div[@class='PortalContainer__container_1jUdq']/div[@class='UILayoutPage__page_VOKnn']/div[@class='UILayoutWrapper__wrapper_2RHiZ']/div[@class='PlatformLayout__layoutPageComponent_1_h0K']/div[@class='PortalContainer__container_1jUdq']/div[@class='Container__container_329R7']/div[@class='UIPayments__providers_FAXNA']/div[@class='PaymentsCategories__slider_Isgo4']/div[@class='Slider__slider_30Y_t']/div[@class='Carousel__container_1z3NF']/div[@class='Carousel__sliderFrame_3TyaJ Carousel__sliderFrame_stretch_1saS5']/div[2]")).click();
        payPage.zkhButtonClick();



        assertTrue(zkhPage.getRegionName().equals("Москве"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String savePage = driver.findElement(By.linkText("ЖКУ-Москва")).getText();

        zkhPage.zkuMoscowButtonClick();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]")).isDisplayed(); //Странная проверка, но она дает возможность получить верную ссылку

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        String url = driver.getCurrentUrl();
        System.out.println(url);
        zkhPage.zkuMoscowPayClick();



        zkhPage.payButtonClick();


        Assert.assertTrue("Element 'Поле обязательное' is not displayed",
                driver.findElement(By.xpath("//form/div[1]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).isDisplayed());
        Assert.assertTrue("Element 'Поле обязательное' is not displayed",
                driver.findElement(By.xpath("//form/div[2]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).isDisplayed());
        Assert.assertTrue("Element 'Поле обязательное' is not displayed",
                driver.findElement(By.xpath("//div[1]/div/div/div[@data-qa-file=\"UIFormRowError\"]")).isDisplayed());



        mainPage.payButtonClick();


        driver.findElement(By.xpath("//input[@placeholder='Название или ИНН получателя платежа']")).sendKeys(savePage);
        driver.findElement(By.xpath("//input[@placeholder='Название или ИНН получателя платежа']")).getText().equals(savePage);// не уверен что верная проверка

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[contains(text(),'ЖКУ-Москва')]")).click();


        if (url.equals("https://www.tinkoff.ru/zhku-moskva/")) {
            System.out.println("Ссылка верна");
        } else {
            System.out.println("Ссылка не верну");
       }
        mainPage.payButtonClick();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        payPage.zkhButtonClick();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@class='Link__link_cnGq8 Link__link_color_blue_JfY21 Link__link_type_simple_2yvi8 Link__link_nodecorated_2N9sy']")).click();
        driver.findElement(By.linkText("г. Санкт-Петербург")).click();

        try{
            driver.findElement(By.xpath("//input[@placeholder='Название или ИНН получателя платежа']")).sendKeys(savePage);
            assertTrue(driver.findElement(xpath("//div[@data-qa-file=\"Text\"][contains(text(), 'Ничего не найдено')]")).getText().equals("Ничего не найдено"));
        }
        catch( TimeoutException | InvalidElementStateException e){
            assertTrue(false);
        }


    }

}
