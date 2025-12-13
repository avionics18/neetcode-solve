import java.util.*;

public class C02_3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0, maxCount = 0;
        Set<Character> substr_set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!substr_set.contains(ch)) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
                substr_set.clear();
            }

            substr_set.add(ch);
        }

        return Math.max(maxCount, count);
    }
}