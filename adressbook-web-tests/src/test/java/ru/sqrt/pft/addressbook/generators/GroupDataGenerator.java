package ru.sqrt.pft.addressbook.generators;


import ru.sqrt.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator
{
  public  static  void  main(String[] arqs) throws IOException
  {
    int count = Integer.parseInt(arqs[0]);
    File file = new File(arqs[1]);

    List<GroupData> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<GroupData> groups, File file) throws IOException
  {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups)
    {
      writer.write(String.format("%s;%s;%s\n", group.getName(),group.getHeader(),group.getFooter()));

    }
    writer.close();

  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withIName(String.format("test %s", i))
              .withIHeader(String.format("header %s", i)).withIFooter(String.format("footer %s", i)));

    }
    return groups;
  }
}
