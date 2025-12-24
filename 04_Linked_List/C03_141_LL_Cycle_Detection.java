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


public class C03_141_LL_Cycle_Detection {
    public static void main(String[] args) {
        // Linked List with cycle
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        ListNode cycle_node = new ListNode(40);
        head.next.next.next = cycle_node;
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        head.next.next.next.next.next.next = new ListNode(70);
        head.next.next.next.next.next.next.next = cycle_node;

        // Detect cycle in LL
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        // Here is the logic is very simple.
        // Run two pointers - slow and fast pointer
        // and if they meet implies the LL has cycle (Rel. Motion).
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}