package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.ContactData;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests  extends  TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().allphones().size() == 0)
    {
      app.contact().create(new ContactData().withFirstname("name11")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333"), true);
    }
  }
  @Test
  public void  testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().allphones().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private  String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public  static String cleaned(String phone)
  {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }
}
