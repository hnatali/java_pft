package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("name11", null, null, null, null ), true);
    }
    List<ContactData>  before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedContact(before.size() - 1);
    app.getContactHelper().initContactModification(before.get(before.size() - 1).getId());
    ContactData modifiedContact = new ContactData(before.get(before.size() - 1).getId(),"name66666666", null, null, null, null);
    app.getContactHelper().fillContactForm(modifiedContact, true);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add ((before.size() - 1), modifiedContact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}