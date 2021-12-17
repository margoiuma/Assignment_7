package assignment7.tests;

import assignment7.pages.US1_LibraryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1_Library {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyingModels(){
        US1_LibraryPage library = new US1_LibraryPage(driver);
        String [] emails = {"librarian54@library", "librarian15@library"};

        for(int i = 0; i < emails.length; i++){

            library.verifyTitle();

            library.emailInput.sendKeys(emails[i]);
            library.passwordInput.sendKeys("Sdet2022*");
            library.signInButton.click();

            library.verifyModels();

            library.logOut();
        }
    }
}
