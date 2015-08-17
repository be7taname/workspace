package common;

// Definition for singly-linked list.
public class ListNode {
	
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	
	public static ListNode genList(int[] valueList)
	{
		ListNode head = new ListNode(valueList[0]);
		ListNode currNode = head;
		for (int i = 1; i < valueList.length; i++) {
			currNode.next = new ListNode(valueList[i]);
			currNode = currNode.next;
		}
		
		return head;
	}
	
}
