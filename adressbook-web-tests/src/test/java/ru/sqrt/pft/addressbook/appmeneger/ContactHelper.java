package ru.sqrt.pft.addressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactHelper  extends HelperBase
{
  public ContactHelper(WebDriver wd)
  {
    super(wd);
  }

  public void gotoAddNewPage()
  {
    wd.findElement(By.linkText("add new")).click();
  }


  public void submitContactCreation()
  {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void updateContact() {
    click(By.name("update"));
  }


  public void fillContactForm(ContactData contactData, boolean creation)
  {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
    if (creation)
    {
      if (contactData.getGroup() != null)
      {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else
      {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
  }


  public void deleteContacts()
  {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
  }

  public void selectedContact(int index)

  {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification()
  {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  private void returnToHomePage()
  {
    if (isElementPresent(By.id("maintable")))
    {
      return;
    }
    click(By.linkText("home page"));
  }

  public void createContact(ContactData contact, boolean b)
  {
    gotoAddNewPage();
    fillContactForm(contact, b);
    submitContactCreation();
    returnToHomePage();

  }

  public boolean isThereAContact()
  {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int getContactCount()

  {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList()
  {
    List<ContactData> groups =  new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']/td[3]"));
    for (WebElement element : elements)
    {
      String name = element.getText();
      ContactData contact = new ContactData(name,null,null, null,null);
      groups.add(contact);
    }
    return groups;
  }
}

