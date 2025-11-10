/**
 * GeneralPractitioner class extends HealthProfessional and adds unique attributes
 * for general practitioners, such as the maximum number of daily slots they can handle.
 * 
 * @author gjiang 24832258
 */
public class GeneralPractitioner extends HealthProfessional {
    private int maxDailySlots; // Unique variable: Max daily slots

    // Default constructor
    public GeneralPractitioner() { 
        super(); 
    }

    /**
     * Constructor with all variables (including parent class + unique subclass variable)
     * 
     * @param id Health professional ID.
     * @param name Health professional's name.
     * @param specialty Health professional's specialty.
     * @param maxDailySlots Max slots available for daily appointments.
     */
    public GeneralPractitioner(int id, String name, String specialty, int maxDailySlots) {
        super(id, name, specialty);
        this.maxDailySlots = maxDailySlots;
    }

    // Overriding the printDetails method (including unique variable)
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("Max Daily Slots: " + maxDailySlots);
    }
}
