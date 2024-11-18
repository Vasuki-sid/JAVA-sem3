class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, String fuelType, double loadCapacity) {
        super(make, model, year, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateMaxSpeed() {
        return 90; // Trucks have a maximum speed of 90 km/h
    }
}
