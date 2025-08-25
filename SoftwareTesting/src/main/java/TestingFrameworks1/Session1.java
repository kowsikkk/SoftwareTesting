package TestingFrameworks1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class Session1 {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();

    }

    @Test
    public void test1() throws IOException
    {
        //creating property fil throws FileNotFoundException
        Properties obj= new Properties();
        // connection b/w java and prop file
        FileInputStream fis= new FileInputStream("./config/config.properties");
        //loading property file object
        obj.load(fis);
        //retrieve data using getProperty()
        String prop1= obj.getProperty("course");
        System.out.println(prop1);
    }


    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
