package TestingFrameworks1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class Session2 {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        driver = new ChromeDriver();
        driver.get("https://www.finology.in/");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("./data/data.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        String data = row.getCell(0).getStringCellValue();
        workbook.close();

        // Perform login
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(data);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();

        // Wait for OTP message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement bodyElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Enter OTP recieved on your Email/Mobile')]"))
        );


        String actualText = bodyElement.getText();
        String expectedText = "Enter OTP recieved on your Email/Mobile";
//        EventHandler.assertEquals(actualText, expectedText);


    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
