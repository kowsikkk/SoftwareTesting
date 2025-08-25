package TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class Session2 {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://spicejet.com");

    }

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        String windowParent = driver.getWindowHandle();

        // Click Signup
        driver.findElement(By.xpath("//div[contains(text(),'Signup')]")).click();
        Thread.sleep(1000);
        // Switch to child window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(windowParent)) {
                driver.switchTo().window(window);
                System.out.println("Switched to child window: " + driver.getTitle());
            }
        }

        // Switch back to parent window
        driver.switchTo().window(windowParent);
        Thread.sleep(3000);

        // Hover using Actions
        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(
                "//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]"
        ));
        action.moveToElement(menu).perform();

        Thread.sleep(3000);



    }



    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}