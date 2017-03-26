package ru.sqrt.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase
{

  @Test
  public void testGroupCreation()
  {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("tests 42", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);
  }

}
