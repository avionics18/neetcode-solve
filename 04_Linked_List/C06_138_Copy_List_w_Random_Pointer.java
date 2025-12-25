import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.val);
    }
}

public class C06_138_Copy_List_w_Random_Pointer {
    public static void main(String[] args) {
        // 7 -> 13 -> 11 -> 10 -> 1 -> null
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        displayList(head);

        Node new_head = copyRandomList(head);

        displayList(new_head);
    }

    // ::::: Facts Missing in the Question :::::
    // In the question it is shown random pointer contains indicies.
    // But in reality, random data member will contain addresses, right.
    // So you can not use the getNode(idx) method for the new list.
    // So, if in the og list, 2nd node's random points to first node,
    // same thing should be applied to our new list.
    // Therefore, it is very evident that we need to use a data structure
    // where it can store these mappings, and also these mappings
    // should not be based out of the node.val as the nodes can have
    // dupliacte values. So, we'll use the unique identifier of node
    // for mapping. So, the mapping would something like below:
    // {
    //    "og_node_1": "new_node_1",
    //    "og_node_2": "new_node_2",
    //    "og_node_3": "new_node_3",
    //    ...,
    // }
    // Thus, when you know to whom does og_node_2 points to
    // lets say og_node_1. Then we know that new_node_2 should
    // point to new_node_1 respectively.


    // ===Approach:===
    // 1. Create the entire LL so that next pointer of each
    // node points to correct location.
    // 2. While new list creation, also create the hashmap
    // of corresponding nodes.
    // 3. Then for each node in og list you know its random value,
    // assign the respective random value for the nodes in new list.
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> nodes_map = new HashMap<>();

        // New LL
        Node head2 = null;
        Node tail2 = null;

        // Insert nodes from og to new list
        Node curr_node = head;
        while (curr_node != null) {
            Node new_node = new Node(curr_node.val);
            if (head2 == null) {
                head2 = new_node;
                tail2 = new_node;
            } else {
                tail2.next = new_node;
                tail2 = new_node;
            }

            // Create the mapping of (old_node, new_node)
            nodes_map.put(curr_node, new_node);

            curr_node = curr_node.next;
        }

        nodes_map.forEach((key_node, value_node) -> {
            value_node.random = nodes_map.get(key_node.random);
        });

        return head2;
    }

    public static void displayList(Node head) {
        // System.out.println("Node | NX | RN");
        Node curr_node = head;
        while (curr_node != null) {
            // System.out.print(curr_node.val + " -> ");
            // System.out.println(curr_node + ", " + curr_node.next + ", " + curr_node.random);
            curr_node = curr_node.next;
        }
        System.out.println("null");
    }
}