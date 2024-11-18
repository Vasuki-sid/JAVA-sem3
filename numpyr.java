import java.util.Scanner;
public class numpyr {
    public static void printNumberPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a positive integer for the pyramid: ");
        int n = scanner.nextInt();
        printNumberPyramid(n);
        scanner.close();
    }
}