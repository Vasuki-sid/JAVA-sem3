public class StringManipulator {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedString.append(reversedWord).append(" ");
        }

        return reversedString.toString().trim();
    }

    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String result = manipulator.reverseWords("Hello World");
        System.out.println(result); // Output: "olleH dlroW"
    }
}