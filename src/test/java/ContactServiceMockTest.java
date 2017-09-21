

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import LPS2IMA.HELIOU.Contact.Contact;
import LPS2IMA.HELIOU.Contact.ContactExistException;
import LPS2IMA.HELIOU.Contact.ContactService;
import LPS2IMA.HELIOU.Contact.IContactDAO;
import LPS2IMA.HELIOU.Contact.RecureperContactExpetion;
import LPS2IMA.HELIOU.Contact.SupprimerContactExpetion;

import org.junit.Assert;

public class ContactServiceMockTest extends MockTest {

	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDAO dao;
	
	@Test(expected = ContactExistException.class)
	public void testCreerContactErr() throws ContactExistException {
		
		//phase d'enregistrement des comportements
		String nom = "Contact OK";
		String tel = "020000000";
		EasyMock.expect(dao.isContactExist(nom)).andReturn(true);
		
		Capture<Contact> capture = EasyMock.newCapture();
		dao.creerContact(EasyMock.capture(capture));
		
		//fin de l'enregistrement
		replayAll();
		
		//appel de la methode
		service.creerContact(nom, tel);
		
		//verification
		verifyAll();
		
		Contact contact = capture.getValue();
		Assert.assertEquals(nom, contact.getNom());
		Assert.assertEquals(tel, contact.getTelephone());
		
	}
	
	@Test
	public void testCreerContactOk() throws ContactExistException {
		
		//phase d'enregistrement des comportements
		String nom = "Contact OK";
		EasyMock.expect(dao.isContactExist(nom)).andReturn(false);
		
		Capture<Contact> capture = EasyMock.newCapture();
		dao.creerContact(EasyMock.capture(capture));
		
		//fin de l'enregistrement
		replayAll();
		
		//appel de la methode
		String telephone = "0200000000";
		service.creerContact(nom, telephone);
		
		//verification
		verifyAll();
		
		Contact contact = capture.getValue();
		Assert.assertEquals(telephone, contact.getTelephone());
	}
	
	@Test
	public void testSupprimerContact() throws SupprimerContactExpetion {
		String nom = "Contact supprimé";
		//EasyMock.expect(dao.suprpimerContact(contact)).andReturn(true);
		
		
	}
	
}
