package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class Session3 {

    static ExtentReports report;
    static ExtentTest test;
    static WebDriver driver;


    @BeforeMethod
    public void setup() throws MalformedURLException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeTest
    public void create() {
        ExtentSparkReporter reporter=new ExtentSparkReporter("./reports/reporter.html");
        report=new ExtentReports();
        report.attachReporter(reporter);
    }

    @Test
    public void test1() {
        test=report.createTest("test1");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        test.log(Status.PASS, "Login Happened");
    }

    @AfterTest
    public void close() {
        report.flush();
    }

    //start your script here

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
