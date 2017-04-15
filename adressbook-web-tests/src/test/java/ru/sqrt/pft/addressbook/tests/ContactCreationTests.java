package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase
{

  @Test
  public void testContactCreation()
  {
    Contacts before = app.contact().all();
    app.contact().newPage();

    File photo = new File("src/test/resources/VOT.jpg");
    ContactData contact  = new ContactData().withFirstname("name11").withPhoto(photo);
    app.contact().create(contact, true);
    assertThat(app.contact().сount(),equalTo(before.size() +1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

