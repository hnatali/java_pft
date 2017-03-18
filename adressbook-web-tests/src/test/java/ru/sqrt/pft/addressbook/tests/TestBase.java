package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.sqrt.pft.addressbook.appmeneger.ApplicatManager;


public class TestBase {

  protected final ApplicatManager app = new ApplicatManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
