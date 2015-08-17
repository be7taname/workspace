package problemset;

import common.ListNode;

public class DeleteDuplicates {
	public ListNode solution(ListNode head)
	{
		if (head == null) return head;
		
		ListNode curNode = head;
		int curVal = curNode.val;
		while (curNode.next != null) {
			if (curNode.next.val == curVal) {
				curNode.next = curNode.next.next;
			} else {
				curNode = curNode.next;
				curVal = curNode.val;
			}
		}
		return head;
	}
}
