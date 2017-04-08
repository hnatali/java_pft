package ru.sqrt.pft.addressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

public class ContactHelper  extends HelperBase
{
  public ContactHelper(WebDriver wd)
  {
    super(wd);
  }

  public void newPage()
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



  public void selectedContactById(int id)

  {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }





  public void initContactModification(int id)
  {
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
  }

  private void returnToHomePage()
  {
    if (isElementPresent(By.id("maintable")))
    {
      return;
    }
    click(By.linkText("home page"));
  }

  public void create(ContactData contact, boolean b)
  {
    newPage();
    fillContactForm(contact, b);
    submitContactCreation();
    returnToHomePage();

  }

  public void modify(Set<ContactData> before, ContactData modifiedContact) {
   selectedContactById(modifiedContact.getId());
   initContactModification(modifiedContact.getId());
   fillContactForm(modifiedContact, true);
   updateContact();
   gotoHomePage();
  }


  public void delete(ContactData contact) {
    selectedContactById(contact.getId());
    deleteContacts();
    homePage();
  }

  public void homePage() {
    if (isElementPresent (By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
  public void gotoHomePage() {
    if (isElementPresent (By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
  public boolean isThereAContact()
  {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int getContactCount()

  {
    return  wd.findElements(By.name("selected[]")).size();
  }



  public Contacts all()
  {
    Contacts contacts =  new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements)
    {
      int id = Integer.parseInt (element.findElement(By.name("selected[]")).getAttribute("id"));
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstName));
    }
    return contacts;
  }


}

