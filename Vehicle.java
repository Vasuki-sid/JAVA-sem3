abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String fuelType;

    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public double calculateFuelEfficiency(double fuelConsumed, double distance) {
        return distance / fuelConsumed;
    }

    public double calculateDistanceTraveled(double fuelCapacity, double fuelEfficiency) {
        return fuelCapacity * fuelEfficiency;
    }

    public abstract double calculateMaxSpeed();
}