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
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
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