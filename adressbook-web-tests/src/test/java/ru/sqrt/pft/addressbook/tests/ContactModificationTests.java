package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().all().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
  }
  @Test
  public void testContactModification()
  {
    Set<ContactData> before = app.contact().all();
    ContactData modifContact = before.iterator().next();
    ContactData modifiedContact = new ContactData()
            .withId(modifContact.getId()).withFirstname("name66666666");
    app.contact().modify(before,modifiedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifContact);
    before.add (modifiedContact);
    Assert.assertEquals(before,after);
  }
}