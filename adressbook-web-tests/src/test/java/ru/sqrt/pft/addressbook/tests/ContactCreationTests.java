package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase
{

  @Test
  public void testContactCreation()
  {
    List<ContactData>  before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("name11", null, null, null, null), true);
    List<ContactData>  after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}

