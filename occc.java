import java.util.Scanner;
public class occc {
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