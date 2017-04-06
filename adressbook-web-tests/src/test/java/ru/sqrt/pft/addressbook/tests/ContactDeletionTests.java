package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().list().size() == 0)
    {
      app.contact().create(new ContactData("name11", null, null, null, null ), true);
    }
  }
  @Test
  public void testContactDeletion()
  {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData>  after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals (before, after);
  }
}
