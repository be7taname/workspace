package problemset;

import common.ListNode;

public class RemoveNthFromEnd {
	public ListNode solution(ListNode head, int n)
	{
		ListNode start, end;
		start = end = head;
		for (int i = 0; i < n; i++) {
			end = end.next;
		}
		if (end == null) return head.next;
		while (end.next != null) {
			start = start.next;
			end = end.next;
		}
		start.next = start.next.next;
		
		return head;
	}
}
