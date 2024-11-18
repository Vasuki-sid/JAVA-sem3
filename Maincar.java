public class Maincar {
    public static void main(String[] args) {
        // Create instances of vehicles
        Truck truck = new Truck("Ford", "F-150", 2022, "Diesel", 1000);
        Car car = new Car("Toyota", "Camry", 2021, "Gasoline", 5);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR600RR", 2020, "Gasoline", true);

        // Calculate fuel efficiency
        double truckFuelEfficiency = truck.calculateFuelEfficiency(10, 100);
        double carFuelEfficiency = car.calculateFuelEfficiency(5, 100);
        double motorcycleFuelEfficiency = motorcycle.calculateFuelEfficiency(2, 100);

        // Calculate distance traveled
        double truckDistance = truck.calculateDistanceTraveled(50, truckFuelEfficiency);
        double carDistance = car.calculateDistanceTraveled(40, carFuelEfficiency);
        double motorcycleDistance = motorcycle.calculateDistanceTraveled(15, motorcycleFuelEfficiency);

        // Calculate maximum speed
        double truckMaxSpeed = truck.calculateMaxSpeed();
        double carMaxSpeed = car.calculateMaxSpeed();
        double motorcycleMaxSpeed = motorcycle.calculateMaxSpeed();

        // Print results
        System.out.println("Truck:");
        System.out.println("Fuel Efficiency: " + truckFuelEfficiency + " km/L");
        System.out.println("Distance Traveled: " + truckDistance + " km");
        System.out.println("Maximum Speed: " + truckMaxSpeed + " km/h");

        System.out.println("\nCar:");
        System.out.println("Fuel Efficiency: " + carFuelEfficiency + " km/L");
        System.out.println("Distance Traveled: " + carDistance + " km");
        System.out.println("Maximum Speed: " + carMaxSpeed + " km/h");

        System.out.println("\nMotorcycle:");
        System.out.println("Fuel Efficiency: " + motorcycleFuelEfficiency + " km/L");
        System.out.println("Distance Traveled: " + motorcycleDistance + " km");
        System.out.println("Maximum Speed: " + motorcycleMaxSpeed + " km/h");
    }
}