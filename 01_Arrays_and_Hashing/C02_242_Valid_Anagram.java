import java.util.*;

public class C02_242_Valid_Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        while (test_cases > 0) {
            String s = sc.next();
            String t = sc.next();
            System.out.println(isValidAnagram(s, t));
            test_cases--;
        }
        sc.close();
    }

    public static boolean isValidAnagram(String s, String t) {
        /*
        * Optimized
        * ---------
        * First check if their lengths are same, cause to be
        * valid anagrams, their length should be same. Then,
        * Create an additional integer array of size 26
        * for each alaphabet of english. Now traverse the
        * s and t string, while traversing - if s contains
        * a character, increment that index of array and if t
        * contains a char, decrement that index of array.
        * Finally if they are valid anagrams, all the 
        * elements of the array will be 0.
        */

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i<s.length(); i++) {
            // Given constraint that both s and t
            // are lowercase letters
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // if they pass all the tests
        // implies they are valid anagrams
        return true;
    }
}