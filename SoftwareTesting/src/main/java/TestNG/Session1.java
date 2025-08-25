package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Session1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Launch Groww
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://groww.in/");
    }

    @Test(priority = 1)   // test2 should run first
    public void test2() {
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Login/Register']"));
        loginBtn.click();
    }

    @Test(priority = 2)   // test1 should run second
    public void test1() {
        WebElement getStarted = driver.findElement(By.xpath("//button[text()='Get started']"));
        getStarted.click();
    }

    @Test(priority = 3)   // test0 should run last
    public void test0() {
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Login/Register']"));
        loginBtn.click();

        // Assert popup contains header text "Welcome to Groww"
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Groww')]"));
        String actualText = header.getText();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
