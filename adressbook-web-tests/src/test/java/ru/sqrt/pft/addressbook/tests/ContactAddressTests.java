package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().alladdress().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }


  public String cleaned(String address) {
    return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}