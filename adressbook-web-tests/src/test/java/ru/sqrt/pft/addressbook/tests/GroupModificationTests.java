package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;
import ru.sqrt.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


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
    Groups before = app.group().all();
    GroupData modifGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifGroup.getId()).withIName("tests 41"). withIHeader("ddddd").withIFooter("d");
    app.group().modify(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifGroup).withAdded(group)));

  }
}
