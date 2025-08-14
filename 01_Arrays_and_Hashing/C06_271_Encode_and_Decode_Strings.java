import java.util.*;

public class C06_271_Encode_and_Decode_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp_str = sc.nextLine();
        sc.close();

        String[] inp_strs = inp_str.split(" ");
        List<String> strs = Arrays.asList(inp_strs);

        String encoded_str = encode(strs);
        List<String> res = decode(encoded_str);
        System.out.println(res);
    }

    public static String encode(List<String> strs) {
        // We will encode the string by putting
        // "#" between all the elements of the list.

        // But first check if the strs list is empty
        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }

        String seperator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(seperator);
            // So the final output will contain
            // "abc#ab#a#" i.e. # will be present
            // at the end.
            // But we need to remove it as the input
            // strs list may actually contain empty strings.
            // 0 <= strs[i].length < 200 (Given)
        }

        sb.deleteCharAt(sb.length() - 1); // delete the last "#"

        return sb.toString();
    }

    public static List<String> decode(String str) {
        if (str.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }

        String seperator = Character.toString((char) 257);

        // passed limit as -1, so that it also includes any
        // empty strings present in the actual string list.
        return Arrays.asList(str.split(seperator, -1));
    }
}