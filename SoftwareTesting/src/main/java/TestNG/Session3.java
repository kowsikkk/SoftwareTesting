package TestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Session3 {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {

        driver.get("https://www.spicejet.com");
    }

    @Test
    public void test() throws IOException {
        String fileName = "spicejet_home";
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File destination=new File("./screenshots/"+fileName+".png");
        FileUtils.copyFile(source, destination);

    }
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}

