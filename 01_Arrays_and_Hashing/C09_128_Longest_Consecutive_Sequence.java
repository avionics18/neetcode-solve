// Longest Consecutive Sequence
// - Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
// - The elements do not have to be consecutive in the original array.
// - input: nums = [0,3,2,5,4,6,1,1]
// - output: 7
// Required Solution: O(n)

import java.util.*;

public class C09_128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        sc.close();

        // -----Brute Force Approach = O(n^3)
        // We maintain two variables LCS_count=1 and CCS_count=1.
        // For each num, find (num+1). Then for (num+1) find
        // (num+1)+1 and accordingly update CCS & LCS count.
        // int count = longestConsecutive_BF(arr);

        // -----Optimized Approach 1 = O(n logn)
        // int count = longestConsecutive_Opt1(arr);

        // -----Optimized Approach 2 = O(n)
        int count = longestConsecutive_Opt2(arr);

        System.out.println(count);
    }

    public static int longestConsecutive_Opt1(int[] nums) {
        // We sort the "nums" array, which results in easier finding
        // of the consecutive sequence.
        // We maintain two variables LCS_count and CCS_count.
        // Start at i = 1, and check for previous element
        // - if curr and prev is equal, continue.
        // - if (curr - prev) is 1, CCS_count++;
        // - if (curr - prev) is not 1, update
        //   LCS_count & CCS_count accordingly.
        // Finally return max(LCS_count, CCS_count).

        Arrays.sort(nums);

        int LCS_count = 1, CCS_count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] - nums[i - 1] == 1) {
                CCS_count++;
            } else {
                if (CCS_count > LCS_count) {
                    LCS_count = CCS_count;
                }
                CCS_count = 1;
            }
        }

        return Math.max(LCS_count, CCS_count);
    }

    public static int longestConsecutive_Opt2(int[] nums) {
        // Since we want to search for a particular
        // element, thus it is better to use a set/map.
        // As they provide methods for instant search
        // of an element - "contains()"

        // Approach
        // ========
        // Store all the distinct elements of array in the set.
        // Now for each number "num", search if (num-1) exists,
        // as it denotes that the current element is not the start
        // of the Longest consecutive sequenec.
        // For the number whose (num-1) does not exist, implies
        // either it is the start of the LCS or it is not.
        // - Now keep searching for num+1, keep incrementing
        //   CCS_count.
        // - At the end update LCS_count accordingly,
        //   and reset CCS_count to 1.

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int LCS_count = 1, CCS_count = 1;


        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int n = num;
                while (set.contains(n + 1)) {
                    CCS_count++;
                    n++;
                }

                if (CCS_count > LCS_count) {
                    LCS_count = CCS_count;
                }

                // reset CCS_count back to 1.
                CCS_count = 1;
            }
        }

        return LCS_count;
    }
}