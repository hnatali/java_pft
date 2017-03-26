package ru.sqrt.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;


public class GroupModificationTests  extends TestBase
{
  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().createGroup (new GroupData("tests 42", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification ();
    app.getGroupHelper().fillGroupForm(new GroupData("tests 41", "ddddd", "d"));
    app.getGroupHelper().sabmitGroupModification ();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
