class Car extends Vehicle {
    private int numSeats;

    public Car(String make, String model, int year, String fuelType, int numSeats) {
        super(make, model, year, fuelType);
        this.numSeats = numSeats;
    }

    @Override
    public double calculateMaxSpeed() {
        return 180; // Cars have a maximum speed of 180 km/h
    }
}
