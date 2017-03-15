package ru.sqrt.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ContactCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ContactCreationTests() {
        wd.get("http://localhost/addressbook/index.php");
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("user"))).build().perform();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("pass"))).build().perform();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]"))).build().perform();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("searchform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("search-az"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("nav"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("add new"))).build().perform();
        wd.findElement(By.linkText("add new")).click();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("add new"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("nav"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']//h1[.='Edit / add address book entry']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("firstname"))).build().perform();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("name11");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("lastname"))).build().perform();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("name12");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("address"))).build().perform();
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("address 11");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("homepage"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email3"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email2"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email"))).build().perform();
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("email11");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("work"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("address2"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("notes"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form/input[21]"))).build().perform();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("footer"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='footer']//li[.='php-addressbook v8.2.5']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.msgbox"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("home page"))).build().perform();
        wd.findElement(By.linkText("home page")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("maintable"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("body"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("body"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
