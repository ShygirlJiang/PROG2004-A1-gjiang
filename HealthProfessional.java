/**
 * HealthProfessional class represents a general health professional.
 * This class contains basic information about a health professional.
 * 
 * @author gjiang 24832258
 */
public class HealthProfessional {
    private int id; 
    private String name; 
    private String specialty; 

    // Default constructor
    public HealthProfessional() {}

    /**
     * Constructor with parameters to initialize all instance variables.
     * 
     * @param id Health professional ID (must be a positive integer).
     * @param name Health professional's name (non-empty).
     * @param specialty Health professional's specialty (non-empty).
     * @throws IllegalArgumentException if id <= 0, name or specialty is null or empty.
     */
    public HealthProfessional(int id, String name, String specialty) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialty cannot be empty");
        }

        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialty cannot be empty");
        }
        this.specialty = specialty;
    }

    // Print health professional details
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
    }
}
