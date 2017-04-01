package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Comparator;
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
    before.add (modifiedContact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort((byId));
    Assert.assertEquals(before,after);
  }
}