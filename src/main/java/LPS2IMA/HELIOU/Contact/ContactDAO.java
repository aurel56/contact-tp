package LPS2IMA.HELIOU.Contact;

import java.util.ArrayList;

public class ContactDAO implements IContactDAO {

  ArrayList<Contact> contacts = new ArrayList<Contact>();

  public ContactDAO() {

  }

  public void creerContact(Contact contact) {
    contacts.add(contact);

  }

  public Contact recupererContact(String nom) {
    return null;
  }

  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(ArrayList<Contact> contacts) {
    this.contacts = contacts;
  }

  public boolean isContactExist(String nom) {
    Boolean exist = false;
    for (Contact contact : contacts) {
      if (contact.getNom().equals(nom)) {
        exist = true;
      }
    }
    return exist;
  }

  public void recupererContact(Contact capture) {
    // TODO Auto-generated method stub

  }

  public void suprpimerContact(Contact contact) {
    // TODO Auto-generated method stub

  }

  public void setContacts() {
    // TODO Auto-generated method stub

  }

  public void supprimerContact(Contact contact) {
    // TODO Auto-generated method stub

  }

}
