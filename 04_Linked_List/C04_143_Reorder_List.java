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

public class C04_143_Reorder_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        // Before Reordering
        displayList(head);

        reorderList(head);

        // After Reordering
        displayList(head);
    }

    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // fast.next != null [ODD]
        // fast != null [EVEN], instead we'll use
        // fast.next.next != null [NEW EVEN]
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode prev_node = null;
        ListNode curr_node = head;

        while (curr_node != null) {
            ListNode next_node = curr_node.next;

            curr_node.next = prev_node;
            prev_node = curr_node;
            curr_node = next_node;
        }

        return prev_node;
    }

    public static void reorderList(ListNode head) {
        // Approach: Divide the LL from the mid-point
        // reverse the second half of the list
        // and then alternatively start inserting the nodes
        // untill any of them becomes null.
        ListNode mid_node = getMiddleNode(head);

        ListNode head2 = mid_node.next;
        ListNode rev_head2 = reverseLL(head2);

        // break the list from mid-point
        mid_node.next = null;

        while (head != null && rev_head2 != null) {
            // insert nodes from rev list and
            // move the pointers ahead

            // backup
            ListNode ahead1 = head.next;
            ListNode ahead2 = rev_head2.next;

            // insert node in between
            rev_head2.next = head.next;
            head.next = rev_head2;

            // increment pointers
            head = ahead1;
            rev_head2 = ahead2;
        }
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