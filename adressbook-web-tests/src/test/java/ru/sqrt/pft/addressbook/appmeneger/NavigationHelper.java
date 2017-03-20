package ru.sqrt.pft.addressbook.appmeneger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NavigationHelper  extends HelperBase{


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
  public void gotoHomePage() {
    click(By.linkText("home"));
  }
}