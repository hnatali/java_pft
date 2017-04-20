package ru.sqrt.pft.addressbook.appmeneger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.sqrt.pft.addressbook.model.ContactData;
import ru.sqrt.pft.addressbook.model.Contacts;
import ru.sqrt.pft.addressbook.model.GroupData;
import ru.sqrt.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

  private SessionFactory sessionFactory;

  public DbHelper() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public GroupData groupById(int groupId) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    GroupData result = (GroupData) session.createQuery("from GroupData where id = " + groupId).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated='0000-00-00' order by id").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
}
