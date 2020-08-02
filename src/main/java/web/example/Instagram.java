package web.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;


public class Instagram {

    protected WebDriver driver;
    public static String loginUrl = "https://www.instagram.com/accounts/login/?source=auth_switcher";

    @Before
    public void setUp() {

        try {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\smhcn\\Desktop\\Java Project\\Driver\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Login() {

        try {
            driver.get(loginUrl);
            driver.findElement(name("username")).sendKeys("kullanıcı_adı");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("sifre");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='Giriş Yap']")).click();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {

    }
}