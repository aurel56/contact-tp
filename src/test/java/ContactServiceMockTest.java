import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;

import LPS2IMA.HELIOU.Contact.Contact;
import LPS2IMA.HELIOU.Contact.ContactExistException;
import LPS2IMA.HELIOU.Contact.ContactService;
import LPS2IMA.HELIOU.Contact.IContactDAO;
import LPS2IMA.HELIOU.Contact.SupprimerContactException;

public class ContactServiceMockTest extends MockTest {

  @TestSubject
  private ContactService service = new ContactService();

  @Mock
  private IContactDAO dao;

  @Test(expected = ContactExistException.class)
  public void testCreerContactErr() throws ContactExistException {

    // phase d'enregistrement des comportements
    String nom = "Contact OK";
    String tel = "020000000";
    EasyMock.expect(dao.isContactExist(nom)).andReturn(true);

    Capture<Contact> capture = EasyMock.newCapture();
    dao.creerContact(EasyMock.capture(capture));

    // fin de l'enregistrement
    replayAll();

    // appel de la methode
    service.creerContact(nom, tel);

    // verification
    verifyAll();

    Contact contact = capture.getValue();
    Assert.assertEquals(nom, contact.getNom());
    Assert.assertEquals(tel, contact.getTelephone());

  }

  /**
   * creation des test creerContactOK.
   * 
   * @author aurel
   */
  @Test
  public void testCreerContactOk() throws ContactExistException {

    // phase d'enregistrement des comportements
    String nom = "Contact OK";
    EasyMock.expect(dao.isContactExist(nom)).andReturn(false);

    Capture<Contact> capture = EasyMock.newCapture();
    dao.creerContact(EasyMock.capture(capture));

    // fin de l'enregistrement
    replayAll();

    // appel de la methode
    String telephone = "0200000000";
    service.creerContact(nom, telephone);

    // verification
    verifyAll();

    Contact contact = capture.getValue();
    Assert.assertEquals(telephone, contact.getTelephone());
  }

  /**
   * creation des test supprimerContact.
   * 
   * @author aurel
   */
  @Test
  public void testSupprimerContact() throws SupprimerContactException {

    // phase d'enregistrement des comportements String telephone = "0200000000";
    String nom = "robert";
    Contact contact = new Contact(nom, telephone);
    String telephone = "0200000000";
    String nom = "robert";
    Contact contact = new Contact(nom, telephone);

    String name = "Contact supprimé";
    EasyMock.expect(dao.isContactExist(name)).andReturn(true);

    Capture<Contact> capture = EasyMock.newCapture();
    dao.supprimerContact(EasyMock.capture(capture));

    // fin de l'enregistrement
    replayAll();

    // appel de la methode

    service.supprimerContact(nom, telephone);

    // verification
    verifyAll();

  }

}
