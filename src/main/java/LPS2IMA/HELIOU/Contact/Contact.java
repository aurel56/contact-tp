package LPS2IMA.HELIOU.Contact;

public class Contact {

  public String nom;
  public String telephone;

  public Contact(String nom, String telephone) {
    super();
    this.nom = nom;
    this.telephone = telephone;
  }

  public String getNom() {
    return nom;
  }

  public String getTelephone() {
    return telephone;

  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

}
