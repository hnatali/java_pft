package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
  }
  @Test
  public void testContactDeletion()
  {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().сount(),equalTo(before.size() - 1));
    Contacts  after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}
