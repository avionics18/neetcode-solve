import java.util.*;

public class C05_347_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        // convert the str to arr
        int[] arr = Arrays.stream(str.split(" "))
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
        int k = sc.nextInt();
        sc.close();

        int[] topElements = topKFrequent(arr, k);
        System.out.println(Arrays.toString(topElements));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // create a hashmap which stores all the
        // distinct elements along with their frequency
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Now create a PriorityQueue/heap which when retrieved
        // gives elements according to a priority
        //  and the priority is in decresing order i.e. max-heap
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Insert the keys from `map` to `heap`
        for (int num : map.keySet()) {
            heap.add(num);
        }

        // Now since we want top k frequent elements
        // poll() the heap k number of times & store in a res[].
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}