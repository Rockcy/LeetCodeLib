package linkedlist;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/12/22 23:30
 * @modified By：
 * @version: 1.0$
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head!= null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}