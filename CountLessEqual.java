import java.util.Arrays;
import java.util.Scanner;
public class CountLessEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the size of the first array
        int n = scanner.nextInt();
        int[] nums = new int[n];
        // Read the elements of the first array
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // Read the size of the second array
        int m = scanner.nextInt();
        int[] maxes = new int[m];
        // Read the elements of the second array
        for (int i = 0; i < m; i++) {
            maxes[i] = scanner.nextInt();
        }
        // Get the result and print it
        int[] result = countLessEqual(nums, maxes);
        for (int res : result) {
            System.out.println(res);
        }
        scanner.close();
    }
    private static int[] countLessEqual(int[] nums, int[] maxes) {
        // Sort the first array
        Arrays.sort(nums);
        int[] result = new int[maxes.length];
        for (int i = 0; i < maxes.length; i++) {
            result[i] = binarySearchCount(nums, maxes[i]);
        }
        return result;
    }
    private static int binarySearchCount(int[] nums, int maxVal) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= maxVal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // left is the count of elements <= maxVal
    }
}                                     