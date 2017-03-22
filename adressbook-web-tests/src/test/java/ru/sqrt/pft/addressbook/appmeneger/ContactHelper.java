package ru.sqrt.pft.addressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqrt.pft.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase{
  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  public void gotoAddNewPage() {
    wd.findElement(By.linkText("add new")).click();
  }


  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void updateContact() {
    click(By.name("update"));
  }



  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse (isElementPresent (By.name("new_group")));
    }
  }


  public void deleteContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
  }

  public void selectedContact() {
    wd.findElement(By.name("selected[]")).click();
  }
  public void initContactModification () {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }
}
