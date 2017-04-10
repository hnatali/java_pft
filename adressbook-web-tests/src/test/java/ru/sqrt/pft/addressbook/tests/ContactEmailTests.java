package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {



  @Test
  public void testContactEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().allemails().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


    assertThat(contact.getEmail(), equalTo(cleaned(contactInfoFromEditForm.getEmail())));
    assertThat(contact.getEmail2(), equalTo(cleaned(contactInfoFromEditForm.getEmail2())));
    assertThat(contact.getEmail3(), equalTo(cleaned(contactInfoFromEditForm.getEmail3())));
  }
  public String cleaned(String email) {
    return email.replaceAll("\\s", "");
  }
}