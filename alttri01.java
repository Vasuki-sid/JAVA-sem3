import java.util.Scanner;
public class alttri01 {
    public static void printAlternatingTriangle(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                if ((i+j)%2==0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a positive integer for the triangle: ");
        int n = scanner.nextInt();
        printAlternatingTriangle(n);
        scanner.close();
    }
}