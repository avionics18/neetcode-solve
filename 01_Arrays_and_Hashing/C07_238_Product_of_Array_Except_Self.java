import java.util.*;

public class C07_238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while (test_cases > 0) {
            String str = sc.nextLine();
            int[] arr = Arrays.stream(str.split(" "))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .toArray();
            // System.out.println(Arrays.toString(productExceptSelf(arr)));
            System.out.println(Arrays.toString(productExceptSelfOpt(arr)));
            test_cases--;
        }

        sc.close();
    }

    public static int[] productExceptSelf(int[] nums) {
        // Create Prefix and Postfic multiplication
        int size = nums.length;
        int[] prefixMul = new int[size];
        int[] postfixMul = new int[size];
        int[] res = new int[size];

        // calculate prefixMul
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                prefixMul[i] = 1;
            } else {
                prefixMul[i] = prefixMul[i - 1] * nums[i - 1];
            }
        }

        // calculate postfixMul
        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) {
                postfixMul[i] = 1;
            } else {
                postfixMul[i] = postfixMul[i + 1] * nums[i + 1];
            }
        }

        for (int i = 0; i < size; i++) {
            res[i] = prefixMul[i] * postfixMul[i];
        }

        return res;
    }

    public static int[] productExceptSelfOpt(int[] nums) {
        // Calc PrefixMul and PostfixMul in the same res[]
        int size = nums.length;
        int[] res = new int[size];

        int pre = 1, post = 1;
        for (int i = 0; i < size; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }

        for (int i = size - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post = post * nums[i];
        }

        return res;
    }
}