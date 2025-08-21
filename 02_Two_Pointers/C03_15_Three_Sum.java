// --- 3 Sum ---
/*
* Approach: For every number nums[i] in the nums[] array
*           search in the remaining part of the array,
*           two elements whose sum is equal to (target - nums[i]).
*           This is nothing but two sum problem which we discussed
*           earlier. Thus for each nums[i] we need to apply the
*           two sum problem to the rest of the array.
*
*           But there's a caveat, suppose the nums[]={1,-5,4,-5,5,0}.
*           Now for i=1 i.e. for (-5), the two numbers that come out
*           to be the result are 5 & 0. Similarly for i=3, again (-5)
*           the results will be same, which will result in duplicates.
*           So, one way to reslove this by "sorting" the array, now the
*           same values will be adjacent to each other, and we can
*           ignore those values in the loop.
*           We need to ignore values two times:
*           1. nums[i] should not be equal to nums[i-1]
*           2. nums[j] should not be equal to nums[j-1],
*              k will automatically become unique if i & j are unique.
*
*           Also, Since the array is sorted, run the loop till nums[i] <= 0.
*           Because for positive numbers, the sum is anyway not going to be 0.
*/
// ------

import java.util.*;

public class C03_15_Three_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        sc.close();

        List<List<Integer>> res = threeSum(arr);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum2(nums, i, res);
            }
        }

        return res;
    }

    public static void twoSum2(int[] nums, int idx, List<List<Integer>> res) {
        int left = idx + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[idx] + nums[left] + nums[right];

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                res.add(Arrays.asList(nums[idx], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
}