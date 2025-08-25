//package runner;
//
//import java.io.IOException;
//
//import org.openqa.selenium.By;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import utils.Base;
//import utils.ExcelReader;
//import utils.LoggerHandler;
//import utils.Reporter;
//import utils.Screenshot;
//import utils.WebDriverHelper;
//
//public class TestCase {
//    Base base;
//    WebDriverHelper webdriver;
//    ExtentTest test;
//    @BeforeMethod
//    public void beforemethod() throws IOException {
//        base=new Base();
//        // base.loadProperties();
//        base.openBrowser();
//        webdriver=new WebDriverHelper(Base.driver);
//    }
//    @Test
//    public void test1() throws InterruptedException {
//        By clickSign=By.xpath("/html/body/div[1]/div[1]/header/div/div/div[4]/div[2]");
//        webdriver.clickOnElement(clickSign);
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        LoggerHandler.info("click on signin");
//        By clickCompany=By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div[3]/a[1]");
//        webdriver.clickOnElement(clickCompany);
//        webdriver.switchToNewWindow();
//        By clickSeller=By.xpath("//a[contains(text(),'Verified seller')]");
//        webdriver.javascriptScroll(clickSeller);
//        webdriver.clickOnElement(clickSeller);
//        webdriver.clickOnElement(By.xpath("//a[contains(text(),'Contact the seller')]"));
//        ExtentReports report=Reporter.generateExtentReport("hiii");
//        test=report.createTest("TestCase");
//        // String filename=Reporter.captureScreenshotAsBase64(Base.driver,"agronetto_screenshot");
//        Reporter.attachScreenshotToReport("agronetto_screenshot", test, "agronetto_screenshot");
//        // report.flush();
//        // System.out.println(filename);
//    }
//
//    @Test
//    public void test2() throws InterruptedException {
//        webdriver.javascriptScroll(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[2]/span[5]/a"));
//        Thread.sleep(1000);
//        webdriver.clickOnElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[2]/span[5]/a"));
//        ExtentReports report=Reporter.generateExtentReport("heeee");
//        // test=report.createTest("TestCase");
//        test.log(Status.PASS, "click on Blog");
//        report.flush();
//        webdriver.hoverOverElement(By.xpath("/html/body/div/div/header/div/section[2]/div/div[1]/div/div[2]/div/div/div/div[1]"));
//        webdriver.clickOnElement(By.xpath("/html/body/div/div/header/div/section[2]/div/div[1]/div/div[2]/div/div/div/div[2]/ul/li[1]/a"));
//        webdriver.switchToNewWindow();
//        webdriver.clickOnElement(By.xpath("/html/body/div/div/header/div/section[2]/div/div[2]/div/div/div/nav/ul/li[4]/a"));
//        Screenshot.captureScreenShot("NoResult_screenshot");
//
//    }
//
//    @Test
//    public void test3() throws IOException {
//        webdriver.waitForElementToBeVisible(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[4]"),20);
//        webdriver.clickOnElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[4]"));
//        ExcelReader.writedata("./data/data.xlsx", "Sheet1", 0, 0, "37178");
//        String val=ExcelReader.readdata("./data/data.xlsx", "Sheet1", 0, 0);
//        webdriver.sendKeys(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div[8]/div/div/div[2]/form/input[3]"),val);
//        webdriver.enterAction(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div[8]/div/div/div[2]/form/input[3]"));
//        webdriver.clickOnElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div/div[2]/div[1]/div[2]/div/div[1]/div"));
//        webdriver.clickOnElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/span[3]"));
//    }
//
//    @AfterMethod
//    public void aftermethod() {
//        Base.driver.quit();
//    }
//}
