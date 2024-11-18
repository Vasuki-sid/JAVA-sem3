import java.util.*;
public class abc{
    
    static boolean isOrdered(String w) {
        for (int i=1;i< w.length();i++) {
            if (w.charAt(i) > w.charAt(i-1)) {
                return true;
            }
        }
        return false;
    }
    
    static int countOrderedWords(String a) {
        String[] ws = a.split(" ");
        int c=0;
        for (String w:ws) {
            if (isOrdered(w)) {
                c++;
            }
        }
        return c;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(countOrderedWords(a)); 
    }
}