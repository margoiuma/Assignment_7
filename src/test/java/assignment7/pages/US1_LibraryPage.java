package assignment7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class US1_LibraryPage {

    WebDriver driver;

    public US1_LibraryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement signInButton;

    @FindBy(id = "navbarDropdown")
    public WebElement logOutDrop;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutBtn;

    public void verifyTitle(){
        Assert.assertEquals(driver.getTitle(), "Login - Library");
    }

    public void verifyModels(){
        List<WebElement> models = driver.findElements(By.xpath("//li[@class='nav-item']"));
        Assert.assertEquals(models.size(), 3);
    }

    public void logOut(){
        logOutDrop.click();
        logOutBtn.click();
    }


}
