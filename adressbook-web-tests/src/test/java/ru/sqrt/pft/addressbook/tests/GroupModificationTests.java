package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupModificationTests  extends TestBase
{
  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().gotoGroupPage();

    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().createGroup (new GroupData("tests 42", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification ();
    app.getGroupHelper().fillGroupForm(new GroupData("tests 41", "ddddd", "d"));
    app.getGroupHelper().sabmitGroupModification ();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
