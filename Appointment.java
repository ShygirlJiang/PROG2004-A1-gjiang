import java.util.*;

/**
 * Appointment class stores details about a patient's appointment with a health professional.
 * It includes patient details, time slot, and the doctor assigned.
 * 
 * @author gjiang 24832258
 */
public class Appointment {
    private String patientName;
    private String patientPhone;
    private String timeSlot;
    private HealthProfessional doctor;

    // Default constructor
    public Appointment() {}

    /**
     * Constructor with parameters to initialize all instance variables and validate input.
     * 
     * @param patientName Patient's name (non-empty).
     * @param patientPhone Patient's phone number (non-empty).
     * @param timeSlot Appointment time slot (HH:MM format).
     * @param doctor Doctor assigned to the appointment.
     * @throws IllegalArgumentException if any required field is invalid.
     */
    public Appointment(String patientName, String patientPhone, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        if (patientPhone == null || patientPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient phone cannot be empty");
        }
        if (!timeSlot.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time slot must be in the format HH:MM");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    // Getter and setter methods with validation
    public void setPatientName(String patientName) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        this.patientName = patientName;
    }

    public void setPatientPhone(String patientPhone) {
        if (patientPhone == null || patientPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient phone cannot be empty");
        }
        this.patientPhone = patientPhone;
    }

    // Print appointment details with null check for doctor
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patientName);
        System.out.println("Phone: " + patientPhone);
        System.out.println("Time: " + timeSlot);
        if (doctor != null) {
            doctor.printDetails();
        } else {
            System.out.println("Doctor: No doctor assigned");
        }
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }
}
