import static org.junit.jupiter.api.Assertions.*;
class ControllerTest {

    @org.junit.jupiter.api.Test
    void contactCreation() {
        Controller test = new Controller();
        String[] info = {"Sebas", "Smith", "123456789", "sebas@mail.com"};
        test.contactCreation(info);
        Contacte c = test.searchingID(1);
        assertNotNull(c);
        assertEquals("Sebas", c.getNom());
        assertEquals("Smith", c.getCognom());
        assertEquals("123456789", c.getTelefon());
        assertEquals("sebas@mail.com", c.getEmail());
        assertNotEquals("Robin", c.getNom());
        assertNotEquals("si", c.getCognom());
    }

    @org.junit.jupiter.api.Test
    void setIdCount() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void currentIDCount() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void deleteContact() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void contactDump() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void searchingID() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void searchingName() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void searchingSurname() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void searchingPhone() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void searchingEmail() {
        Controller test = new Controller();

    }

    @org.junit.jupiter.api.Test
    void updatingContacte() {
        Controller test = new Controller();

    }
}