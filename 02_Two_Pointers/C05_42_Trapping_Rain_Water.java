import java.util.*;

public class C05_42_Trapping_Rain_Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        sc.close();

        // System.out.println(trap(arr));
        System.out.println(trap_2pointer(arr));
    }

    public static int trap(int[] height) {
        // ::GOAL::
        // The goal is to find the trapped waters in the given elevation map.

        // The approach will be to find the amount of water trapped on top
        // of each block. Water will be trapped on top of any block only
        // when there are surfaces around that block i.e.
        // min(LMaxH, RMaxH) - curr_h > 0

        // Thus, our new goal is to find the LMaxH and RMAxH for each
        // position and that too in most efficient manner.

        // BruteForce: for each position, find in left array and right array.

        // Optimized_1: First completely iterate from left side, and you will
        //              get the LMaxH[i] at each position in O(n).
        //              Similarly, from right side and you'll get RmaxH[i]
        //              at each position.

        //              Finally, summation over
        //              min(LMaxH, RMaxH) - curr_h for positive values.

        int[] LMaxH = new int[height.length];
        int[] RMaxH = new int[height.length];

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i - 1]);
            LMaxH[i] = max;
        }

        max = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            RMaxH[i] = max;
        }

        // Calc the water trapped
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.max(
                                0,
                                Math.min(LMaxH[i], RMaxH[i]) - height[i]
                            );
        }

        return trappedWater;
    }

    public static int trap_2pointer(int[] height) {
        // ::Optimized_2:: We use Two-Pointer approach
        //                 to calculate the amount of water
        //                 trapped on top of each block.

        // The main concept of this problem is that the water trapped
        // depends on the minimum height of the surrounding surfaces.
        // We have two pointers left and right. And two variables
        // tracking left max height and right max height.
        // We move the pointers whichever is less, and calculate
        // the water trapped at each position and update the
        // left max / right max height accordingly.
        // T.C = O(n) & S.C = O(1)

        int left = 0, right = height.length - 1;
        int LMaxH = height[left], RMaxH = height[right];
        int trappedWater = 0;

        // Update the pointer whichever is less
        while (left < right) {
            if (LMaxH < RMaxH) {
                left++;
                // Calculate the water trapped
                trappedWater += Math.max(0, LMaxH - height[left]);
                // update LMaxH
                LMaxH = Math.max(LMaxH, height[left]);
            } else {
                right--;
                // Calculate the water trapped
                trappedWater += Math.max(0, RMaxH - height[right]);
                // update RMaxH
                RMaxH = Math.max(RMaxH, height[right]);
            }
        }

        return trappedWater;
    }
}