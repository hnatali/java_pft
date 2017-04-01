package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase
{

  @Test
  public void testContactCreation()
  {
    List<ContactData>  before = app.getContactHelper().getContactList();

    app.getContactHelper().gotoAddNewPage();
    ContactData contact  = new ContactData("name11", null, null, null, null);
    app.getContactHelper().createContact(contact, true);
    List<ContactData>  after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);



    before.add(contact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort((byId));
    Assert.assertEquals(before,after);
  }
}

