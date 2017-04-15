package ru.sqrt.pft.addressbook.generators;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sqrt.pft.addressbook.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator
{
  @Parameter (names = "-c", description = "Contact count")
  public  int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public  static  void  main(String[] arqs) throws IOException
  {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander JCommander = new JCommander(generator);
    try
    {
      JCommander.parse(arqs);
    } catch (ParameterException ex)
    {
      JCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = genereateContacts(count);
    if (format.equals("csv"))
    {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Неизвестный формат" + format);
    }

    }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();

  }


  private static void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
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

