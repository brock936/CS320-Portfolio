import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("1234567890", futureDate, "Dentist Appointment");
        assertEquals("1234567890", appt.getAppointmentId());
        assertEquals(futureDate, appt.getAppointmentDate());
        assertEquals("Dentist Appointment", appt.getDescription());
    }

    @Test
    public void testInvalidId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    public void testPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Description");
        });
    }

    @Test
    public void testLongDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        String longDesc = "This is a very long appointment description that exceeds fifty characters";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, longDesc);
        });
    }
}
