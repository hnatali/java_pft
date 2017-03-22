package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
  app.getContactHelper().initContactModification();
  app.getContactHelper().fillContactForm(new ContactData("name777", "name888", "address 999", "email010", null), false);
  app.getContactHelper().updateContact();
  app.getNavigationHelper().gotoHomePage();
    System.out.println();
  }
}