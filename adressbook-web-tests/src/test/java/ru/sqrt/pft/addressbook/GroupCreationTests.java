package ru.sqrt.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("tests 41", "ddddd", "d"));
    submitGroupCreation();
    returnToGroupPage();

  }

}
