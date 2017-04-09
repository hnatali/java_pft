package ru.sqrt.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().all().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
  }
  @Test
  public void testContactModification()
  {
    Contacts before = app.contact().all();
    ContactData modifContact = before.iterator().next();
    ContactData modifiedContact = new ContactData()
            .withId(modifContact.getId()).withFirstname("name66666666");
    app.contact().modify(before,modifiedContact);
    assertThat(app.contact().сount(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifContact).withAdded(modifiedContact)));
  }
}