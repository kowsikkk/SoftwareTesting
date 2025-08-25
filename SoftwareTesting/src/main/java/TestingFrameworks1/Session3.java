package TestingFrameworks1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Session3 {
    public static WebDriver driver;
    public static int IMPLICIT_WAIT_TIME =10;
    public static int  PAGE_LOAD_TIME =15;
    public static String url;

    @BeforeMethod
    public void openBrowser() throws Throwable {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        //get url
        FileInputStream fis=new FileInputStream("./config/config.properties");
        Properties obj=new Properties();
        obj.load(fis);
        url=obj.getProperty("url");
        driver.get(url);


    }

    @Test
    public void test() throws IOException {
        FileInputStream fis=new FileInputStream("./data/data.xlsx");
        Workbook workbook =new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        String data=row.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(data, Keys.ENTER);
        workbook.close();
        fis.close();

    }

    @AfterMethod
    private void after(){
        if(driver!=null){
            driver.quit();
        }
    }

}
