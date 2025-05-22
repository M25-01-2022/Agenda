import static org.junit.jupiter.api.Assertions.*;
class ControllerTest {

    @org.junit.jupiter.api.Test
    void contactCreation() {
        Controller test = new Controller();
        String[] info = {"Sebas", "Smith", "123456789", "s@mail.com"};
        test.contactCreation(info);
        Contacte c = test.searchingID(1);
        assertNotNull(c);
        assertEquals("Sebas", c.getNom());
        assertEquals("Smith", c.getCognom());
        assertEquals("123456789", c.getTelefon());
        assertNotEquals("sebas@mail.com", c.getEmail());
        assertNotEquals("Robin", c.getNom());
        assertNotEquals("si", c.getCognom());
    }

    @org.junit.jupiter.api.Test
    void setIdCount() {
        Controller test = new Controller();
        test.setIdCount(5);
        assertEquals(5, test.currentIDCount());
        assertNotEquals(4, test.currentIDCount());
    }

    @org.junit.jupiter.api.Test
    void currentIDCount() {
        Controller test = new Controller();
        assertEquals(0, test.currentIDCount());
        assertNotEquals(5, test.currentIDCount());
        test.setIdCount(7);
        assertEquals(7, test.currentIDCount());
        assertNotEquals(2, test.currentIDCount());
    }

    @org.junit.jupiter.api.Test
    void deleteContact() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Bob", "Lee", "111", "b@hotmail.com"});
        test.deleteContact(0);
        assertNull(test.searchingID(0));
    }

    @org.junit.jupiter.api.Test
    void contactDump() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"A", "B", "1", "a@b.com"});
        test.contactCreation(new String[]{"C", "D", "2", "c@d.com"});
        assertDoesNotThrow(() -> test.contactDump());
    }

    @org.junit.jupiter.api.Test
    void searchingID() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"X", "Y", "999", "x@y.com"});
        Contacte c = test.searchingID(1);
        assertNotNull(c);
        assertEquals("X", c.getNom());
    }

    @org.junit.jupiter.api.Test
    void searchingName() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Carlos", "Ramirez", "333", "c@r.com"});
        Contacte c = test.searchingName("carlos");
        assertNotNull(c);
        assertEquals("Ramirez", c.getCognom());
        assertEquals("333", c.getTelefon());
        assertNotEquals("Carlos", c.getEmail());
    }

    @org.junit.jupiter.api.Test
    void searchingSurname() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Luis", "Mendez", "444", "l@m.com"});
        Contacte c = test.searchingSurname("mendez");
        assertNotNull(c);
        assertEquals("Luis", c.getNom());
        assertNotEquals("l@m.com", c.getNom());
    }

    @org.junit.jupiter.api.Test
    void searchingPhone() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Sara", "Gomez", "555", "s@g.com"});
        Contacte c = test.searchingPhone("555");
        assertNotNull(c);
        assertEquals("Sara", c.getNom());
        assertNotEquals("Gomez", c.getNom());
    }

    @org.junit.jupiter.api.Test
    void searchingEmail() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Nina", "Lopez", "666", "nina@l.com"});
        Contacte c = test.searchingEmail("nina@l.com");
        assertNotNull(c);
        assertEquals("Nina", c.getNom());
        assertNotEquals("Lopez", c.getTelefon());
    }

    @org.junit.jupiter.api.Test
    void updatingContacte() {
        Controller test = new Controller();
        test.contactCreation(new String[]{"Lola", "Perez", "777", "lola@p.com"});
        Contacte updated = test.updatingContacte(1, "Clara", "*", "*", "c@mail.com");
        assertNotNull(updated);
        assertEquals("Clara", updated.getNom());
        assertNotEquals("*", updated.getCognom());
        assertNotEquals("naiara@mail.com", updated.getEmail());
    }
}