package LPS2IMA.HELIOU.Contact;

import java.util.ArrayList;

public interface IContactDAO {
	
	public void creerContact(Contact contact);
	
	public Contact recupererContact(String nom);
	
	public boolean isContactExist(String nom);

	public void recupererContact(Contact capture);
	
	public ArrayList<Contact> getContacts();
	
	public void suprpimerContact(Contact contact);
	
	

}
