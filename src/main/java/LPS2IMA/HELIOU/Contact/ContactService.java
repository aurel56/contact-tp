package LPS2IMA.HELIOU.Contact;

public class ContactService {

	
	IContactDAO contactDAO = new ContactDAO();
	
	public ContactService() {
		
	}
		
	public Contact creerContact(String nom, String telephone) throws ContactExistException {
		Contact contact;
		if(nom !=null) {
			
			if((nom.length()>=3 && (nom.length()<=40) )) {
				contact = new Contact(nom, telephone);
				
				if(contactDAO.isContactExist(nom)) {
					throw new ContactExistException();
				}
				contactDAO.creerContact(contact);
				
			}else {
				throw new IllegalArgumentException("le nom doit avoir entre 3 et 40 caract�res");			
			}
		}else{
			throw new IllegalArgumentException("pas de nom saisi");
		}			
	return contact;	
	}
	
	public void suprpimerContact(Contact contact) throws ContactExistException {
		for(int i=0; i<contactDAO.getContacts().size(); i++) {
			if(contactDAO.getContacts().get(i)==contact) {
				contactDAO.getContacts().remove(i);
			}
			
		}
	}
	
	public void modifierContact(Contact contact) throws ContactExistException {
		
	}
}
