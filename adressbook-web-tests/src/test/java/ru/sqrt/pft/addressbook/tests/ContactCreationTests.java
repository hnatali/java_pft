package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase
{

  @Test
  public void testContactCreation()
  {
    app.getContactHelper().gotoAddNewPage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("name11", null, null, null, null), true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}

