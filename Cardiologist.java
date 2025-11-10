/**
 * Cardiologist class extends HealthProfessional and adds a unique attribute for cardiologists,
 * such as the subspecialty (e.g., Coronary Artery Disease).
 * 
 * @author gjiang 24832258
 */
public class Cardiologist extends HealthProfessional {
    private String subspecialty; // Unique variable: Cardiology subspecialty

    // Default constructor
    public Cardiologist() {
        super(); // Calling parent class default constructor
    }

    /**
     * Constructor with all variables (including parent class + unique subclass variable)
     * 
     * @param id Health professional ID.
     * @param name Health professional's name.
     * @param specialty Health professional's specialty.
     * @param subspecialty Cardiologist's subspecialty (e.g., "Coronary Artery Disease").
     */
    public Cardiologist(int id, String name, String specialty, String subspecialty) {
        super(id, name, specialty);
        this.subspecialty = subspecialty;
    }

    // Overriding the printDetails method (including unique variable)
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: Cardiologist");
        super.printDetails();
        System.out.println("Subspecialty: " + subspecialty);
    }
}
