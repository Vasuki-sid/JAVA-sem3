/*
import java.util.Scanner;
public class hhh {
    public static int factorial(int n) {
        return (n==0)?1:n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sumOfFactorials = 0;
        while (number>0) {
            int digit=number%10;
            sumOfFactorials += factorial(digit);
            number/=10;
        }
        System.out.println((sumOfFactorials == originalNumber) ? "Strong number" : "Not a strong number");
        scanner.close();
    }
}*/
import java.util.Scanner;
public class hi{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int original = scanner.nextInt();
        int result = findFinalValue(nums, original);
        System.out.println(result);
        scanner.close();
    }
    private static int findFinalValue(int[] nums, int original){
        while (ch(nums, original)) {
            original*=2;
        }
        return original;
    }
    private static boolean ch(int[] nums, int target) {
        for(int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}