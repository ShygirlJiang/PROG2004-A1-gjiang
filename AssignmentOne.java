import java.util.*;

/**
 * Main class to run the appointment system. It creates health professional objects,
 * appointments, and manages them using ArrayList.
 * 
 * @author gjiang 24832258
 */
public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        // 3 General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Smith", "General Medicine", 8);
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Lee", "General Medicine", 6);
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Brown", "General Medicine", 7);

        // 2 Cardiologist objects
        Cardiologist cardio1 = new Cardiologist(4, "Dr. Johnson", "Cardiology", "Coronary Artery Disease");
        Cardiologist cardio2 = new Cardiologist(5, "Dr. Davis", "Cardiology", "Arrhythmia");

        // Print details of all objects
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
        cardio1.printDetails();
        System.out.println("------------------------------");
        cardio2.printDetails();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            // Create 2 GP appointments
            createAppointment(appointments, "John Doe", "123456789", "08:00", gp1);
            createAppointment(appointments, "Alice White", "456789123", "09:30", gp2);

            // Create 2 Cardiologist appointments
            createAppointment(appointments, "Bob Green", "789123456", "14:00", cardio1);
            createAppointment(appointments, "Charlie Black", "321654987", "15:30", cardio2);

            // Print existing appointments
            printExistingAppointments(appointments);

            // Cancel one appointment
            cancelBooking(appointments, "123456789");

            // Print appointments again
            printExistingAppointments(appointments);
        } catch (AppointmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Part 5 ends with the mandatory separator line
        System.out.println("------------------------------");
    }

    // Print existing appointments in the list
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    // Create an appointment and add to the list
    public static boolean createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.isEmpty() 
            || patientPhone == null || patientPhone.isEmpty() 
            || timeSlot == null || !timeSlot.matches("\\d{2}:\\d{2}") 
            || doctor == null) {
            System.out.println("Failed to create appointment: All required information must be provided (valid format for time slot).");
            return false;
        }
        Appointment newAppt = new Appointment(patientName, patientPhone, timeSlot, doctor);
        appointments.add(newAppt);
        System.out.println("Appointment created successfully for patient: " + patientName);
        return true;
    }

    // Cancel an appointment based on patient phone
    public static void cancelBooking(ArrayList<Appointment> appointments, String patientPhone) 
            throws AppointmentNotFoundException {
        if (patientPhone == null || patientPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient phone cannot be empty");
        }
        boolean found = false;
        for (Iterator<Appointment> iterator = appointments.iterator(); iterator.hasNext();) {
            Appointment appointment = iterator.next();
            if (patientPhone.equals(appointment.getPatientPhone())) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new AppointmentNotFoundException("No appointment found with phone number: " + patientPhone);
        }
    }
}
