import java.util.Scanner;
import java.util.stream.IntStream;
public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Use streams to determine if the number is even or odd
        int result = IntStream.of(number)
                              .map(n -> (n % 2 == 0) ? 2 : 1)
                              .findFirst()
                              .orElse(1); // Default to 1 if no value is found

        // Print the result
        System.out.println(result);

        scanner.close();
    }
}