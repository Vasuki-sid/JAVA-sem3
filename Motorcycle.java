class Motorcycle extends Vehicle {
    private boolean hasHelmetHook;

    public Motorcycle(String make, String model, int year, String fuelType, boolean hasHelmetHook) {
        super(make, model, year, fuelType);
        this.hasHelmetHook = hasHelmetHook;
    }

    @Override
    public double calculateMaxSpeed() {
        return 150; // Motorcycles have a maximum speed of 150 km/h
    }
}
