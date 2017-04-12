package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("name11").withLastname("name12")
                      .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
                      .withEmail("email@1").withEmail2("email@2").withEmail3("email@3")
                      .withAddress("Санкт-Петербург Район  ул.Улица д.1"),
              true);
    }
  }
  @Test
  public void testContactDetailsInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().allinfo().iterator().next();
    ContactData contactInfoFromEdit = app.contact().infoFromEditForm(contact);
    String contactInfoFromDetails = app.contact().infoFromDetails(contact);


    assertThat(cleaned(contactInfoFromDetails), equalTo(mergeEdit(contactInfoFromEdit)));

  }

  private  String mergeEdit(ContactData contact) {
    return Arrays.asList(contact.getFirstname(),contact.getLastname(),
            contact.getAddress(), "H:",
            contact.getHomePhone(),"M:",contact.getMobilePhone(),"W:",contact.getWorkPhone(),
            contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactComparingInfo::cleaned)
            .collect(Collectors.joining(""));
  }





  public  static String cleaned(String info) {
    return info.replaceAll("\\s", "").replaceAll("[-()]","").replaceAll("\n","");
  }


}
