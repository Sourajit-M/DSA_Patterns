package fast_and_slow_pointers;
import data.ListNode;

// https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedList_Cycle_I {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;

        // Create cycle: -4 → 2
        node4.next = node2;

        System.out.println(hasCycle(head));
    }
}
