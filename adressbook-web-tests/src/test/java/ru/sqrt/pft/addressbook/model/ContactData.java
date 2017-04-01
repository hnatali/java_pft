package ru.sqrt.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String email;
  private String group;

  public String getId() {
    return id;
  }

  public ContactData(String id, String firstname, String lastname, String address, String email, String group)
  {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public ContactData( String firstname, String lastname, String address, String email, String group)
  {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.email = email;
    this.group = group;
  }



  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }








  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
  }


}
