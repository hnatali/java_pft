package ru.sqrt.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase
{

  @Test
  public void testGroupCreation()
  {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("tests 42", null, null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);
  }
}
