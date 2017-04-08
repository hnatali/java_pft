package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase
{

  @Test
  public void testContactCreation()
  {
    Set<ContactData> before = app.contact().all();
    app.contact().newPage();
    ContactData contact  = new ContactData().withFirstname("name11");
    app.contact().create(contact, true);
    Set<ContactData>  after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}

