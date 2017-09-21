

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import LPS2IMA.HELIOU.Contact.ContactExistException;
import LPS2IMA.HELIOU.Contact.ContactService;


public class TestContactService {
	private ContactService service ; 
	@Before
	public void start() {
		service = new ContactService() ;
	}
	@Test
	public void testCreerContactWithCorrectParameter() throws ContactExistException {
		service.creerContact("ALbert","0200000000");
		assertTrue(true);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCreerContactNomTropCourt() throws ContactExistException {
		service.creerContact("Ab","0200000000");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCreerContactNomTropLong() throws ContactExistException {
		service.creerContact("Aaaaaaaaaaabbbbbbbbbllllllllllleeeeeeeeerrrrrrrrrrrttttttt","0200000000");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCreerContactNomExistePas() throws ContactExistException {
		service.creerContact("Robert","0200000000");
	//}


}
