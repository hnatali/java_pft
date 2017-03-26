package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification()
  {
    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new ContactData("name11", null, null, null, null), true);
    }
    List<ContactData>  before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("name777", null, null, null, null), true);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}