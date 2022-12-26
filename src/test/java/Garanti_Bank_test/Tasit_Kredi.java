package Garanti_Bank_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tasit_Kredi {
    public static void main(String[] args) throws InterruptedException {
        /*
        https://www.garantibbva.com.tr/ sitesine gidilerek
        ikinci el araç kredi 150.000 liralık kredi ve ödeme
        planı alınacak
        proje maven ile yapılmıştır.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        //open Garanti bankası main page
        driver.get("https://www.garantibbva.com.tr/");
        //driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//ul[@class='mainbar__navlist js-mainbar__navlist']")).click();
        WebElement pagedown1= driver.findElement(By.xpath("//a[@href='/krediler/kredi-basvurusu']"));
        pagedown1.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        //taşıt kredisi seçeneğini seç
        driver.findElement(By.xpath("(//span[@class='tabs__linktext'])[3]")).click();
        //Aracın durumu 2. el seç
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='2. El']")).click();
        // Kredi limit 150.000 lira gir
        WebElement krediTutari= driver.findElement(By.xpath("//input[@id='js-credit__input-PERSONAL_AUTO']"));
        krediTutari.click();
        krediTutari.sendKeys(Keys.BACK_SPACE);
        krediTutari.sendKeys(Keys.BACK_SPACE);
        krediTutari.sendKeys(Keys.BACK_SPACE);
        krediTutari.sendKeys(Keys.BACK_SPACE);
        krediTutari.sendKeys(Keys.BACK_SPACE);
        krediTutari.sendKeys(Keys.BACK_SPACE);
        //
        krediTutari.sendKeys("150.000");
        // ödeme ve masraflar sekmesini aç
        driver.findElement(By.xpath("//span[text()='Ödeme Planı ve Masraflar']")).click();
        //ödeme planı pdf dosya indir
        driver.findElement(By.xpath("//span[text()='PDF İndir']")).click();


        System.out.println("All processes OK");
        Thread.sleep(5000);
        driver.close();





    }

}
