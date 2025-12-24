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

public class C02_21_Merge_Sorted_Lists {
    public static void main(String[] args) {
        // List 1
        ListNode head1 = new ListNode(10);
        head1.next = new ListNode(20);
        head1.next.next = new ListNode(30);
        head1.next.next.next = new ListNode(40);

        // List 2
        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(25);
        head2.next.next.next = new ListNode(36);

        System.out.print("List1: ");
        displayList(head1);
        System.out.print("List2: ");
        displayList(head2);

        // Final Merged List
        ListNode sorted_list = mergeTwoLists(head1, head2);
        System.out.print("Merged List: ");
        displayList(sorted_list);
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // Here we traverse both the list simulateneously
        // If keep on linking the smaller nodes, we get the
        // final sorted list.
        // Finally if any list is left out, join with its 
        // starting node and then you get the fully 
        // sorted merged list.

        // TRICK: you need a dummy node to start with.
        ListNode dummy_node = new ListNode(0);
        ListNode curr_node = dummy_node;
        while (head1 != null && head2 != null)  {
            if (head1.val <= head2.val) {
                curr_node.next = head1;
                curr_node = head1;
                head1 = head1.next;
            } else {
                curr_node.next = head2;
                curr_node = head2;
                head2 = head2.next;
            }
        }

        if (head1 == null) {
            curr_node.next = head2;
        }

        if (head2 == null) {
            curr_node.next = head1;
        }

        // return the head of this list
        return dummy_node.next;
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