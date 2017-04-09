package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;
import ru.sqrt.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase
{
  @Test
  public void testGroupCreation()
  {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withIName("tests 45");
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size() +1));
    Groups after = app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadGroupCreation()
  {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withIName("");// не знаю  недопустимых значений поля
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }

}
