package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactComparingInfo extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("name11").withLastname("name12")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withEmail("email@1").withEmail2("email@2").withEmail3("email@3").withAddress("Санкт-Петербург Район  ул.Улица д.1"),

      true);

    }
  }

  @Test
  public void testContactComparingInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().allinfo().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllInfo(), equalTo(mergeAllInfo(contactInfoFromEditForm)));

  }

  private  String mergeAllInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstname(),contact.getLastname(),
            contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
            contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactComparingInfo::cleaned)
            .collect(Collectors.joining("\n"));
  }
  public  static String cleaned(String info) {
    return info.replaceAll("\\s", "").replaceAll("[-()]","");
  }
}
