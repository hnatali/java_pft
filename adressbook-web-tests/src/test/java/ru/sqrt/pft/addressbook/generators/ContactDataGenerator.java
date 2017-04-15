package ru.sqrt.pft.addressbook.generators;


import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.GroupData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator
{
  public  static  void  main(String[] arqs) throws IOException {
    int count = Integer.parseInt(arqs[0]);
    File file = new File(arqs[1]);

    List<ContactData> contacts = genereateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts)
    {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),contact.getFirstname(),
              contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(),
              contact.getEmail(),contact.getEmail2(),contact.getEmail3(),
              contact.getAddress()));

    }
    writer.close();

  }

  private static List<ContactData> genereateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("name11 %s",  i)).withLastname(String.format("name12 %s",  i))
              .withHomePhone(String.format("111 %s",  i)).withMobilePhone(String.format("222 %s",  i)).withWorkPhone(String.format("333 %s",  i))
              .withEmail(String.format("email@1 %s",  i)).withEmail2(String.format("email@2 %s",  i)).withEmail3(String.format("email@3 %s",  i))
              .withAddress(String.format("Санкт-Петербург Район  ул.Улица д.1  %s",  i)));
    }
    return contacts;
  }

  }

