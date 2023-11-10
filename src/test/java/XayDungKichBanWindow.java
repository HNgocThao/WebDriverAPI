import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class XayDungKichBanWindow {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://test.warface.codegym.vn");
//        String mainWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        String newWindowHandle = driver.getWindowHandle();
        driver.get("https://test.warface.codegym.vn/login");

        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("admin@codegym.vn");
        driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//button")).click();

        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.navigate().refresh();

//        Set<String> allWindowHandles = driver.getWindowHandles();
        driver.switchTo().window(newWindowHandle);
//        System.out.println("Get All Window "+allWindowHandles);
//        for (String windowHandle : allWindowHandles) {
//            if (!windowHandle.equals(mainWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }

        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.findElement(By.xpath("//h6[text()='hoa la canh mau xanh do tim vàng đen đủ thứ']/following::a[text()=\"Mua hàng\" and position()=2]")).click();
        driver.findElement(By.xpath("//h6[text()='hoa la canh mau xanh do tim vàng đen đủ thứ']/following::a[text()=\"Mua hàng\" and position()=4]")).click();
        driver.findElement(By.xpath("//a[@href=\"https://test.warface.codegym.vn/cart\" and position()=2]")).click();

    }
}
