import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(":");
        StringBuffer output = new StringBuffer(); 
        for (String word : words) {
            char C1 = word.charAt(0);
            char C2 = word.charAt(1);
            if (C1 == C2) {
                output.append(Character.toUpperCase(C1));
            } else {
                int maxVal = Math.max(C1-'a'+1,C2-'a'+1);//find excat ascii value
                int minVal = Math.min(C1-'a'+1,C2-'a'+1);
                int position = maxVal - minVal; 
                if (position > 0) {
                    char resultChar = (char) ('A' + position - 1);//find exact char
                    output.append(resultChar);
                }
            }
        }
        System.out.println("Output: " + output.toString());
        sc.close();
    }
}