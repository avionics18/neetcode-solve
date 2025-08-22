import java.util.*;

public class C04_11_Container_With_Most_Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        sc.close();

        System.out.println(containerWithMostWater(arr));
    }

    public static int containerWithMostWater(int[] heights) {
        // ::Brute Force Approach::
        // For each height bar form containers with other height bars
        // and calculate the area, max area denotes most water stored.
        // area = Math.min(heights[i], heights[j]) * (j - i)
        // update the max_area and return it. T.C = O(n^2)

        // ::Optimized Approach - Two Pointers::
        // left = 0 & right = length - 1
        // calculate the area between two heights
        // and then update the max_area if needed.
        // move the left/right pointer whichever
        // is small in height, as the area is dependent
        // on the smaller height bar.
        int left = 0, right = heights.length - 1;
        int max_area = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            max_area = Math.max(max_area, area);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max_area;
    }
}