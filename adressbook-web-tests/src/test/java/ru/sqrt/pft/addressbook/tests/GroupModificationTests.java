package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;

import java.util.Set;


public class GroupModificationTests  extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().groupPage();
    if (app.group().all().size() == 0)
    {
      app.group().create(new GroupData().withIName("tests 42"));
    }
  }
  @Test
  public void testGroupModification()
  {
    Set<GroupData> before = app.group().all();
    GroupData modifGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifGroup.getId()).withIName("tests 41"). withIHeader("ddddd").withIFooter("d");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifGroup);
    before.add (group);
    Assert.assertEquals(before,after);
  }
}
