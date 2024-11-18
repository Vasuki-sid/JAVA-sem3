import java.util.Scanner;

public class WKORWE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of the week: ");
        String day = scanner.nextLine();
        switch (day.toLowerCase()) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                System.out.println("It’s a weekday");
                break;
            case "saturday":
            case "sunday":
                System.out.println("It’s a weekend");
                break;
            default:
                System.out.println("Invalid day");
        }
        scanner.close(); // Close the scanner
    }
}