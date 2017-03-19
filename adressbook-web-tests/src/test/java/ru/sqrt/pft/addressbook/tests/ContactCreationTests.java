package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().fillContactForm(new ContactData("name11", "name12", "address 11", "email11"));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();

  }

}

