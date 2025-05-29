import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contacte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "name")
    private String nom;

    @Column(name = "surnames")
    private String cognom;

    @Column(name = "phone")
    private String telefon;

    @Column(name = "email")
    private String email;

    //Needed by hibernate
    protected Contacte(){}

    protected Contacte(String name, String surnames, String phone, String email) {
        this.nom = name;
        this.cognom = surnames;
        this.telefon = phone;
        this.email = email;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.nom;
    }

    public String getSurnames() {
        return this.cognom;
    }

    public String getPhone() {
        return this.telefon;
    }

    public String getEmail() {
        return this.email;
    }

    protected void setName(String name) {
        this.nom = name;
    }

    protected void setSurnames(String surnames) {
        this.cognom = surnames;
    }

    protected void setPhone(String phone) {
        this.telefon = phone;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return String.format("ID: %d\n  Name: %s\n  Surname: %s\n  Phone: %s\n  Email: %s", this.ID, this.nom, this.cognom, this.telefon, this.email);
    }

    public String toFileContent(){
        return String.format("%d\n%s\n%s\n%s\n%s", this.ID, this.nom, this.cognom, this.telefon, this.email);
    }
}