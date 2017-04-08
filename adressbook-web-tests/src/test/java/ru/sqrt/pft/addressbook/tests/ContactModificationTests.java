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
    app.goTo().homePage();
    if (app.contact().list().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
  }
  @Test
  public void testContactModification()
  {
    List<ContactData>  before = app.contact().list();
    int  index = before.size() - 1;
    ContactData modifiedContact = new ContactData()
            .withId(before.get(index).getId()).withFirstname("name66666666");
    app.contact().modify(before, index, modifiedContact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add (modifiedContact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort((byId));
    Assert.assertEquals(before,after);
  }
}