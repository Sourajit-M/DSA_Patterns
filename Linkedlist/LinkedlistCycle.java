package Patterns.Linkedlist;

public class LinkedlistCycle {
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);

        // Link the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println(hasCycle(head));
    }
}