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


public class C01_206_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        // Before Reverse
        displayList(head);

        // After Reverse
        ListNode new_head = reverseList(head);
        displayList(new_head);
    }

    public static ListNode reverseList(ListNode head) {
        // We need three nodes in order to reverse a LL.
        // - track the prev node (whom to point)
        // - track the current node (whose next value needs to change)
        // - track the next node (where to move next)
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

    public static void displayList(ListNode head) {
        ListNode curr_node = head;
        while (curr_node != null) {
            System.out.print(curr_node.val + " -> ");
            curr_node = curr_node.next;
        }
        System.out.println("null");
    }
}