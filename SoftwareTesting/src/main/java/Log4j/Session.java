package Log4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




import java.time.Duration;

public class Session {
    public static WebDriver driver;
    public static int IMPLICIT_WAIT_TIME =10;
    public static int  PAGE_LOAD_TIME =15;
    public static Logger logger=Logger.getLogger(Session.class);
    @BeforeMethod
    public void openBrowser() throws Throwable {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        //get
        driver.get("https://www.amazon.in");
        PropertyConfigurator.configure("log4j.properties");
        WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        logger.info("Connecting to driver");
    }

    @Test
    public void test(){
        logger.info("Navigating to Amazon...");

        logger.debug("Amazon page title is: " + driver.getTitle());

        logger.warn("This is a sample warning log.");
        logger.error("This is a sample error log for testing.");

    }
    @AfterMethod
    public void am(){
        if(driver!=null)driver.quit();

    }
}
