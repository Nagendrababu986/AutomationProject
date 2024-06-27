import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(JobbyAppReport.class)

public class LoginPageTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagen\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority=1)
    public void testLoginWithEmptyInputs(){
        WebElement Login=driver.findElement(By.className("login-button"));
        Login.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement error=driver.findElement(By.className("error-message"));
        String Error=error.getText();
        Assert.assertEquals(Error, "*Username or password is invalid", "Error text with empty input fields does not match");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyUsername(){
        WebElement Password=driver.findElement(By.id("passwordInput"));
        Password.sendKeys("rahul@2021");
        WebElement Login2=driver.findElement(By.className("login-button"));
        Login2.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement error=driver.findElement(By.className("error-message"));
        String Error=error.getText();
        Assert.assertEquals(Error, "*Username or password is invalid", "Error text with empty field do not match");
    }
    @Test(priority = 3)
    public void testLoginWithEmptyPassword(){
        WebElement Username=driver.findElement(By.id("userNameInput"));
        Username.sendKeys("rahul");
        WebElement Login3=driver.findElement(By.className("login-button"));
        Login3.click();
        WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement error3=driver.findElement(By.className("error-message"));
        String Error3=error3.getText();
        Assert.assertEquals(Error3, "*Username or password is invalid", "Error text with empty field do not match");
    }
    @Test(priority = 4)
    public void testLoginWithInvalidCreds(){
        WebElement Username1=driver.findElement(By.id("userNameInput"));
        Username1.sendKeys("rahul");
        WebElement Password1=driver.findElement(By.id("passwordInput"));
        Password1.sendKeys("rahul");
        WebElement Login4=driver.findElement(By.className("login-button"));
        Login4.click();
        WebDriverWait wait4=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement error4=driver.findElement(By.className("error-message"));
        String Error4=error4.getText();
        Assert.assertEquals(Error4, "*username and password didn't match", "Error text with empty field do not match");
    }
    @Test(priority = 5)
    public void testLoginWithValidCreds(){
        WebElement Username1=driver.findElement(By.id("userNameInput"));
        Username1.sendKeys("rahul");
        WebElement Password1=driver.findElement(By.id("passwordInput"));
        Password1.sendKeys("rahul@2021");
        WebElement Login5=driver.findElement(By.className("login-button"));
        Login5.click();
        String ExpectedUrl="https://qajobbyapp.ccbp.tech/";
        WebDriverWait wait5=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait5.until(ExpectedConditions.urlToBe(ExpectedUrl));
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(actual, ExpectedUrl, "URLs do not match");
    }
}
