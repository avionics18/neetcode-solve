import java.util.*;

public class C02_167_Two_Sum_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        sc.close();

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        // Two Pointer approach
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // 1-based indexing
                return new int[] {(left + 1), (right + 1)};
            }
        }

        return null;
    }
}