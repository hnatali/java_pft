package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("name11", null, null, null, null ), true);
    }
  }
  @Test
  public void testContactDeletion()
  {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedContact(before.size() - 1);
    app.getContactHelper().deleteContacts();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData>  after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals (before, after);
  }
}
