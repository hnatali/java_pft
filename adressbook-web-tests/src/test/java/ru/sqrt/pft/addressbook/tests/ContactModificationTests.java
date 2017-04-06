package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase
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
  public void testContactModification()
  {
    List<ContactData>  before = app.getContactHelper().getContactList();
    int  index = before.size() - 1;
    ContactData modifiedContact = new ContactData(before.get(index).getId(),"name66666666", null, null, null, null);
    app.getContactHelper().modifyContact(before, index, modifiedContact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add (modifiedContact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort((byId));
    Assert.assertEquals(before,after);
  }
}