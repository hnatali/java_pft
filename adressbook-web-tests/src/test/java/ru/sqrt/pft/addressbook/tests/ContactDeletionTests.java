package ru.sqrt.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqrt.pft.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase{

    
    @Test
    public void testContactDeletion () {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectedContact();
        app.getContactHelper().deleteContacts();
        app.getNavigationHelper().gotoHomePage();
    }
}
