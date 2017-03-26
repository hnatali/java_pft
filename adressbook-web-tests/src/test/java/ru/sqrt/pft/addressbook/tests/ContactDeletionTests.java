package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase
{


  @Test
  public void testContactDeletion()
  {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact (new ContactData("name11", null, null, null, null ),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedContact(before.size() - 1);
    app.getContactHelper().deleteContacts();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData>  after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
