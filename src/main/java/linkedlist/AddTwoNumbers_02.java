package linkedlist;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/12/22 21:02
 * @modified By：
 * @version: 1.0$
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers_02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode pre = curr;
        int carry = 0, sum = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            sum = a + b + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }
}
