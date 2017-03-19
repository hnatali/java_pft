package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;


public class GroupModificationTests  extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification ();
    app.getGroupHelper().fillGroupForm(new GroupData("tests 41", "ddddd", "d"));
    app.getGroupHelper().sabmitGroupModification ();
    app.getGroupHelper().returnToGroupPage();
  }
}
