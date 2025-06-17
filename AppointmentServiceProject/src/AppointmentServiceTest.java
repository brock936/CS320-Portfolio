import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        appointment = new Appointment("abc123", futureDate, "Checkup");
    }

    @Test
    public void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("abc123"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }

    @Test
    public void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("abc123");
        assertNull(service.getAppointment("abc123"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("nonexistent");
        });
    }
}
