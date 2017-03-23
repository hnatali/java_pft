package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact (new ContactData("name11", null, null, null, null ),true);

    }
    app.getContactHelper().selectedContact();
    app.getContactHelper().deleteContacts();
    app.getNavigationHelper().gotoHomePage();
  }
}
