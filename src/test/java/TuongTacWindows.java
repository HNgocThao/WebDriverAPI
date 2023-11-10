import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Set;

public class TuongTacWindows {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/elements
        driver.get("https://demoqa.com/alertsWindows");

        // Click "Browser Windows"
        String browserWinXPath = "//span[text()='Browser Windows']";
        WebElement browserWinEle = driver.findElement(By.xpath(browserWinXPath));
        browserWinEle.click();

        // Get current windows
        String currentWin = driver.getWindowHandle();
        System.out.println("Current window: " + currentWin);

        // Thực hiện click vào từng button (03 buttons)
        WebElement newTabEle = driver.findElement(By.id("windowButton"));
        newTabEle.click();



        Set<String> windowList = driver.getWindowHandles();
        System.out.println(MessageFormat.format("The total windows: {0}", windowList.size()));



        // Switch to a new window
        for (String win : windowList) {
            if (!win.equals(currentWin)){
                driver.switchTo().window(win);
            }
        }
        System.out.println("New window: " + driver.getWindowHandle());
        WebElement textWindow2Ele = driver.findElement(By.id("sampleHeading"));
        String textValue = textWindow2Ele.getText();
//        String textValue = textWindow2Ele.toString();
        if (textValue.equals("This is a sample page"))
            System.out.println("Verify the window text : successfully - " + textValue);

        // Back về trang chủ tại bước 2 (Sử dụng phương thức get window đầu tiên và switchTo)
        driver.switchTo().window(currentWin);
    }
}
