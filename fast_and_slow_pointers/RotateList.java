package fast_and_slow_pointers;
import data.ListNode;

// https://leetcode.com/problems/rotate-list/description/
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;

        ListNode temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }

        k = k % n;

        if(k == 0)
            return head;

        temp.next = head;

        temp = head;

        for(int i = 0; i < n-k-1; i++){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        head = rotateRight(head, k);
        printList(head);
    }
}
