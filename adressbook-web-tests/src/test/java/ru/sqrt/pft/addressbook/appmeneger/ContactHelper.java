package ru.sqrt.pft.addressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;

import java.util.HashSet;
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
    contactCach = null;
    returnToHomePage();

  }

  public void modify(Set<ContactData> before, ContactData modifiedContact) {
   selectedContactById(modifiedContact.getId());
   initContactModification(modifiedContact.getId());
   fillContactForm(modifiedContact, true);
   updateContact();
   contactCach = null;
   gotoHomePage();
  }


  public void delete(ContactData contact) {
    selectedContactById(contact.getId());
    deleteContacts();
    contactCach = null;
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

  public int сount()
  {
    return  wd.findElements(By.name("selected[]")).size();
  }


  private Contacts contactCach = null;

  public Contacts all()
  {
    if (contactCach != null) {
      return  new Contacts(contactCach);
    }
    contactCach =  new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements)
    {
      int id = Integer.parseInt (element.findElement(By.name("selected[]")).getAttribute("id"));
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      contactCach.add(new ContactData().withId(id).withFirstname(firstName));
    }
    return new Contacts(contactCach);
  }

  public Set<ContactData> allphones() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] emails = cells.get(4).getText().split("\n");
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return contacts;
  }


  public Set<ContactData> allemails() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] emails = cells.get(4).getText().split("\n");
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withEmail(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]));
    }
    return contacts;
  }


  public Set<ContactData> alladdress() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] address = cells.get(3).getText().split("\n");
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address[0]));
    }
    return contacts;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();


    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lasttname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }
}

