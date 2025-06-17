import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void initService() {
        service = new ContactService();
        contact = new Contact("C001", "Sophia", "Davis", "3216549870", "1600 Spring Lane");
        service.addContact(contact);
    }

    @Test
    public void testAddContactWithDuplicateId() {
        Contact duplicate = new Contact("C001", "Ella", "Watson", "1231231234", "77 River Road");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    public void testDeleteExistingContact() {
        service.deleteContact("C001");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("C001"));
    }

    @Test
    public void testUpdateMultipleFields() {
        service.updateFirstName("C001", "Sophie");
        service.updateLastName("C001", "Martinez");
        service.updatePhone("C001", "1119998888");
        service.updateAddress("C001", "998 Ocean Drive");

        assertEquals("Sophie", contact.getFirstName());
        assertEquals("Martinez", contact.getLastName());
        assertEquals("1119998888", contact.getPhone());
        assertEquals("998 Ocean Drive", contact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("XYZ123", "NewName"));
    }
}
