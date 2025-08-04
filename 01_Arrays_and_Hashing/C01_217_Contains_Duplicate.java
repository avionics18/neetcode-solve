import java.util.*;

public class C01_217_Contains_Duplicate {
    public static void main(String[] args) {
        // take the size as input
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        // input for array
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Brute Force Approach
        // System.out.println(containsDuplicate_BF(arr, size));

        // Optimized Approach
        System.out.println(containsDuplicate_Opt1(arr, size));

        sc.close();
    }

    public static boolean containsDuplicate_Opt1(int[] arr, int size) {
        /*
        * Optimized
        * -----------
        * Use a DS which stores only unique elements
        * and can quickly check if an element exists or not.
        * - HashSet
        */
        HashSet<Integer> seenNums = new HashSet<>();

        /*
        * Store the element in the HashSet,
        * only if it is coming for the first time,
        * if it already exists implies it's duplicate.
        * Hence return true.
        */
        for (int i = 0; i<size; i++) {
            if (seenNums.contains(arr[i])) {
                return true;
            }
            seenNums.add(arr[i]);
        }

        // if the array elements pass the above
        // for loop implies there are no duplicates.
        return false;
    }

    public static boolean containsDuplicate_BF(int[] arr, int size) {
        /*
        * Brute Force
        * ------------
        * For each element, traverse the rest of the
        * array if it contains any duplicate.
        */
        for (int i = 0; i < size; i++) {
            for (int j = (i + 1); j < size; j++) {
                if (arr[i] == arr[j]) {
                    // implies array contains duplicate
                    return true;
                }
            }
        }

        // if array passes for loop
        // implies it does not contain
        // any duplicates.
        return false;
    }
}