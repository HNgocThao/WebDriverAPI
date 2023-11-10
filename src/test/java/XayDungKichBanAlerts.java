import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XayDungKichBanAlerts {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("Vincent");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        driver.findElement(By.xpath("//input[@name='submit']")).click();
        alert.accept();

    }
}
