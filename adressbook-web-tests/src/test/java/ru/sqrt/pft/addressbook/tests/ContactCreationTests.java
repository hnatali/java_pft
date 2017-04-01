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


    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}

