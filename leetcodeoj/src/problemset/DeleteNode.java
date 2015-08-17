package problemset;

import common.ListNode;

public class DeleteNode {
	public void solution(ListNode node)
	{
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
