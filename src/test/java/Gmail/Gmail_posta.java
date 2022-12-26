package Gmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Gmail_posta {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

/*
        gmail'e gidip test account açılarak bir test maili atılacaktır.
        https://www.google.com/intl/tr/gmail/about/

 */

        driver.get("https://www.google.com/intl/tr/gmail/about/");
        // oturum aç butonuna tıkla
        driver.findElement(By.xpath("//a[text()='Oturum açın']")).click();
        // email adresini gir enter la
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("tmaventest@gmail.com");
        driver.findElement(By.xpath("//span[text()='Sonraki']")).click();
        // şifre gir
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@aria-label='Şifrenizi girin']")).sendKeys("Passw0rd123+");
       driver.findElement(By.xpath("//span[text()='Sonraki']")).click();
       // mail oluştur
        driver.findElement(By.xpath("//div[text()='Oluştur']")).click();
        // kime
        driver.findElement(By.xpath("//input[@id=':bz']")).sendKeys("omermenekse@gmail.com");
        //konu
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("test mesaj");
        //mail
        driver.findElement(By.xpath("//div[@id=':9a']")).sendKeys("test mesajı maven projesi");
        // send mail
        driver.findElement(By.xpath("//div[@id=':7t']")).click();

        System.out.println("Test ok. sented message");
        Thread.sleep(5000);
        driver.close();


    }
}
