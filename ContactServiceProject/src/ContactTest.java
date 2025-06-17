import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testCreateValidContact() {
        Contact contact = new Contact("C98765", "Emma", "Brown", "9876543210", "789 Maple Avenue");
        assertEquals("C98765", contact.getContactId());
        assertEquals("Emma", contact.getFirstName());
        assertEquals("Brown", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("789 Maple Avenue", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C12345678901", "Emma", "Brown", "9876543210", "789 Maple Avenue");
        });
    }

    @Test
    public void testNullAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1234", "Liam", "Green", "9998887777", null);
        });
    }

    @Test
    public void testSetLastNameValidUpdate() {
        Contact contact = new Contact("C1010", "Ava", "Smith", "1112223333", "123 Lake Blvd");
        contact.setLastName("Johnson");
        assertEquals("Johnson", contact.getLastName());
    }

    @Test
    public void testSetPhoneInvalidLength() {
        Contact contact = new Contact("C888", "Noah", "Lee", "5555555555", "45 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }
}
