class ServiceProvider {
    private int id;
    private String name;
    private String description;
    private String email;
    private String address;
    private int numberOfDesigners;
    private String services;

    // Constructor
    public ServiceProvider(int id, String name, String description, String email, String address, int numberOfDesigners, String services) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.address = address;
        this.numberOfDesigners = numberOfDesigners;
        this.services = services;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Service Provider ID: " + id + "\nName: " + name + "\nDescription: " + description + "\nEmail: " + email + "\nAddress: " + address + "\nNumber of Designers: " + numberOfDesigners + "\nServices: " + services;
    }
}
