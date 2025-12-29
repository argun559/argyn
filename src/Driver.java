public class Driver {

    private String name;
    private String licenseNumber;

    public Driver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public void displayDriverInfo() {
        System.out.println("Driver name: " + name);
        System.out.println("License number: " + licenseNumber);
    }
}

