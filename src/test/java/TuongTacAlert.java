import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TuongTacAlert {
    public static void main(String[] args) throws InterruptedException{
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/elements
        driver.get("https://demoqa.com/alertsWindows");

        // Click "Alerts" tại thanh menu bar
        String alertXPath = "//span[text()='Alerts']";
        WebElement alertWinEle = driver.findElement(By.xpath(alertXPath));
        alertWinEle.click();

        Alert alert = driver.switchTo().alert();

        WebElement alerta = driver.findElement(By.id("alertButton"));
        alerta.click();
        alert.accept();

        WebElement alertb = driver.findElement(By.id("timerAlertButton"));
        alertb.click();
        Thread.sleep(6000);
        alert.accept();

        WebElement alertc = driver.findElement(By.id("confirmButton"));
        alertc.click();
        alert.dismiss();

        // Thực hiện mở từng alert bằng cách click vào [Click me]
        WebElement alertEle = driver.findElement(By.id("promtButton"));
        alertEle.click();

        // Switch to Alert
        String alertText  = alert.getText();
        System.out.println("Text : " + alertText);

        alert.sendKeys("Automation Test - 2023");
        alert.accept();

        WebElement alertTextRes = driver.findElement(By.id("promptResult"));
        System.out.println("Your text: " + alertTextRes.getText());

    }
}
