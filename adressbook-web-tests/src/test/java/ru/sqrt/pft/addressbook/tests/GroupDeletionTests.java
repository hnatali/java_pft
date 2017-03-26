package ru.sqrt.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase
{

  @Test
  public void testGroupDeletion()
  {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().createGroup (new GroupData("tests 42", null, null));

    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
