package Patterns.Linkedlist;

public class ReversalOfLinkedlist {
    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node reverseLL_part(Node head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        Node before = null;
        Node after = head;
        int pos = 1;
        while (after != null && pos < left) {
            before = after;
            after = after.next;
            pos++;
        }

        if (after == null) {
            return head;
        }

        Node prev = null;
        Node curr = after;

        for (int i = 0; i < right - left + 1 && curr != null; i++) {
            Node nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }

        after.next = curr;

        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        display(head);
        Node temp = reverseLL(head);
        display(temp);

        // Reconstruct the list for testing reverseLL_part
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node temp2 = reverseLL_part(head, 2, 4);
        display(temp2);
    }
}
