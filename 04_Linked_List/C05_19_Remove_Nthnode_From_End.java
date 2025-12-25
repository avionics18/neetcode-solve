import java.util.*;

class ListNode {
    int val;
    ListNode next;

    // constructors
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class C05_19_Remove_Nthnode_From_End {
    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);

        displayList(head);

        // value of n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // remove nth node from end
        // ListNode new_head = removeNthFromEndBF(head, n);
        ListNode new_head = removeNthFromEndOpt(head, n);
        displayList(new_head);
    }

    public static ListNode removeNthFromEndOpt(ListNode head, int n) {
        // Optimized Approach: Offset Method
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // ::::: Edge Case :::::
        // Whenever we want to delete the first node, the n index passed will
        // be equal to the length of LL, so when building the offset, "first"
        // pointer will reach at null as both the pointers are starting
        // from head i.e. 1st node. And nothing will run for second node, but even it runs we can not get the expected output as we want a prev_node
        // for first node which is not possible. So for that case we have to
        // handle it manually. Therefore,
        if (first == null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }

        ListNode temp = second.next;
        second.next = second.next.next;
        temp.next = null;

        return head;
    }

    public static int getSize(ListNode head) {
        int size = 0;
        ListNode curr_node = head;
        while (curr_node != null) {
            size++;
            curr_node = curr_node.next;
        }

        return size;
    }

    public static ListNode getNode(ListNode head, int size, int idx) throws Exception {
        if (idx < 0 || idx > size - 1) {
            throw new Exception("Invalid Index Passed!" + idx);
        }

        int k = 0;
        ListNode curr_node = head;
        while (k != idx) {
            curr_node = curr_node.next;
            k++;
        }

        return curr_node;
    }

    public static ListNode removeNthFromEndBF(ListNode head, int n) throws Exception {
        // Approach: Brute Force
        // Removing nth node from end is euqivalent
        // to removing (N - n)th node from start
        // and for that we need to reach till (N-n-1).
        // NOTE: indexing begins from 0 for start of LL.

        int size = getSize(head);

        // ::::: EDGE CASE :::::
        // Whenever we want to remove the first node itself
        // then n will be equal to the length of the LL.
        // And the value passed in getNode will be -1, which
        // ultimately will throw an error. So, only when you
        // want to remove the first node i.e. n == size,
        // you need to handle this case seperately.
        if (n == size) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        ListNode prev_node = getNode(head, size, size - n - 1);
        ListNode temp = prev_node.next;
        prev_node.next = prev_node.next.next;
        temp.next = null; // del the nth node

        return head;
    }

    public static void displayList(ListNode head) {
        ListNode curr_node = head;
        while (curr_node != null) {
            System.out.print(curr_node.val + " -> ");
            curr_node = curr_node.next;
        }
        System.out.println("null");
    }
}