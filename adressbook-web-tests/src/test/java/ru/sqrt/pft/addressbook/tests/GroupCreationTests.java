package ru.sqrt.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("tests 41", "ddddd", "d"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }

}
