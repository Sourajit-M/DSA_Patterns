package 

public class LinkedlistCycleII {
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle: -4 -> 2
        fourth.next = second;

        Node start_node = detectCycle(head);

        System.out.println(start_node.val);
    }
}
