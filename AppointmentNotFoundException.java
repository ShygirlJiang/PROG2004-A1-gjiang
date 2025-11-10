/**
 * Custom exception for when an appointment is not found.
 * 
 * @author gjiang 24832258
 */
public class AppointmentNotFoundException extends Exception {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
