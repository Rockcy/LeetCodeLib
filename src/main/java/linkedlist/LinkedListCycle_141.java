package linkedlist;

import java.util.HashSet;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/12/25 0:20
 * @modified By：
 * @version: 1.0$
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
    public boolean hasCycleByTwoPointers(ListNode head) {
        if (head == null||head.next==null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
