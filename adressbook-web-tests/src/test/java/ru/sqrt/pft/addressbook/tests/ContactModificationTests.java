package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;
import ru.sqrt.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifContact = before.iterator().next();
    ContactData modifiedContact = new ContactData()
            .withId(modifContact.getId()).withFirstname("name33333").withLastname("fff")
            .withAddress(modifContact.getAddress())
            .withEmail(modifContact.getEmail())
            .withEmail2(modifContact.getEmail2())
            .withEmail3(modifContact.getEmail3());
    app.contact().modify(before, modifiedContact);
    assertThat(app.contact().сount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    Contacts cc = before.without(modifContact).withAdded(modifiedContact);
    assertThat(after, equalTo(cc));
  }
}