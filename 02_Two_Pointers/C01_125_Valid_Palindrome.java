import java.util.*;

public class C01_125_Valid_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // Brute Force
        // System.out.println(isPalindrome(str));

        // Optimized Approach - Two Pointers
        System.out.println(isPalindrome_Opt(str));
    }

    public static boolean isPalindrome(String s) {
        // remove all the non-alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        // Compare the string with its reverse
        String s1 = sb.toString().toLowerCase();
        String s2 = sb.reverse().toString().toLowerCase();

        return s1.equals(s2);
    }

    public static boolean isPalindrome_Opt(String s) {
        // We use the two pointers approach,
        // one start from left and other from the right.
        // And start comparing by lowercasing only the valid
        // characters i.e. alphanumeric chars
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Before comparing we need to check
            // 1. if left is not alphanumeric
            //    then keep on incrementing till
            //    we have a valid alphanumeric digit
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // 2. if right is not alphanumeric
            //    then keep on incrementing till
            //    we have a valid alphanumeric digit
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // If both have alphanumeric character
            // then compare if they are equal otherwise
            // return false. (LowerCase*)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // prep for next iteration
            left++;
            right--;
        }

        // if loop completes
        // implies left half is equal
        // to right half.
        return true;
    }
}