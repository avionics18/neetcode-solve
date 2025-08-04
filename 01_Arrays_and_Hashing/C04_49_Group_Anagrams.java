import java.util.*;

public class C04_49_Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = groupAnagrams(strs);
        // print the result
        System.out.println(res);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // create a hashmap containing
        // count array as key, and whosoever string
        // produces the same key, must be associated with
        // that key (value of key will be list of string)
        HashMap<String, List<String>> map = new HashMap<>();

        // Now for each string s in strs[] array,
        // generate the count array
        for (String s : strs) {
            int[] count = new int[26]; // [0,0,...]

            // for each char in s, increment
            // the respective index in count[].
            // But convert s to array of characters
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }

            // Convert count array to string
            // but note that the string should
            // not be ambiguous, so use '#'.
            StringBuilder sb = new StringBuilder("");
            for (int c : count) {
                sb.append("#");
                sb.append(c);
            }
            String key = sb.toString();

            // Evrything is ready.
            // Check if key is already present,
            // if not create key and empty list
            // add the value. And if already present
            // just add the value i.e. string
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}