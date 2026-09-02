
package Patterns.Linkedlist;

public class ReorderList {
    public static Node reorderList(Node head) {
        Node first = head;
        Node mid = middle(head);
        Node second = mid.next;
        mid.next = null;
        second = reverse(second);

        while (first != null && second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

        return head;
    }

    static Node middle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        return prev;
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
        head.next.next.next.next = new Node(5);

        // 1 -> 2 -> 3 -> 4 -> 5
        // 1 -> 5 -> 2 -> 4 -> 3

        head = reorderList(head);
        display(head);

    }
}