package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;
import ru.sqrt.pft.addressbook.model.GroupData;
import ru.sqrt.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("name11"), true);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withIName("tests 42"));
    }
  }

  @Test
  public void addContactToGroupTest() {
    app.contact().homePage();

    Groups groups = app.db().groups();
    GroupData groupToAddContact = groups.iterator().next();
    app.contact().removeContactsFromGroup(groupToAddContact.getId());
    app.contact().homePage();
    app.contact().goToAllContacts();

    Contacts contacts = app.db().contacts();
    ContactData contactForSelection = contacts.iterator().next();

    Contacts contactsInGroupBefore = app.db().groupById(groupToAddContact.getId()).getContacts();

    app.contact().selectedContactById(contactForSelection.getId());
    app.contact().addContactToGroup(groupToAddContact.getId());
    Contacts contactsInGroupAfter = app.db().groupById(groupToAddContact.getId()).getContacts();

    assertThat(contactsInGroupBefore.size() + 1, equalTo(contactsInGroupAfter.size()));
    assertThat(contactsInGroupAfter, equalTo(contactsInGroupBefore.withAdded(contactForSelection)));
  }

  @Test
  public void deleteContactFromGroup() {
    app.contact().homePage();

    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contactData = contacts.iterator().next();

    GroupData groupToDeleteContact = groups.iterator().next();
    app.contact().selectedContactById(contactData.getId());
    app.contact().addContactToGroup(groupToDeleteContact.getId());
    app.contact().homePage();

    Contacts contactsBefore = app.db().groupById(groupToDeleteContact.getId()).getContacts();
    app.contact().goToGroup(groupToDeleteContact.getId());
    app.contact().selectedContactById(contactData.getId());
    app.contact().removeSelectedContact();
    app.contact().homePage();

    Contacts contactsAfter = app.db().groupById(groupToDeleteContact.getId()).getContacts();
    assertThat(contactsBefore.size() - 1, equalTo(contactsAfter.size()));

  }


}
