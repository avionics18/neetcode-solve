import java.util.*;

public class C03_1_Two_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        while (test_cases > 0) {
            sc.nextLine(); // for \n in input
            String str = sc.nextLine();
            // convert a string into an integer array
            int[] nums = Arrays.stream(str.split(" "))
                         .filter(s -> !s.isEmpty())
                         .mapToInt(Integer::parseInt)
                         .toArray();
            int target = sc.nextInt();
            int[] res = twoSum(nums, target);
            System.out.println(Arrays.toString(res));
            test_cases--;
        }
        sc.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        /*
        * Optimized
        * ---------
        * We create a store(hashmap) of potential solutions untill we get
        * the solution for which complementary exists in the hashmap whose
        * sum equals the target.
        * 
        * Use a HashMap containing:
        * { value: index } i.e. potential solution
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // check if complement exists in teh hashmap
            if (map.containsKey(complement)) {
                // we need to return in sorted order
                int j = map.get(complement);
                if (i < j) {
                    return new int[] {i, j};
                } else {
                    return new int[] {j, i};
                }
            }

            // if map does not contain complement
            // then store the "num" as potential solution
            map.put(nums[i], i);
        }

        // if no such solution exists
        // return an empty array
        return new int[] {};
    }
}