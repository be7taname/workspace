package problemset;

import common.ListNode;

public class GetIntersectionNode {
	public ListNode solution(ListNode headA, ListNode headB)
	{
		int lenA, lenB;
		ListNode curA, curB;
		
		lenA = lenB = 0;
		curA = headA;
		while (curA != null) {
			curA = curA.next;
			lenA++;
		}
		curB = headB;
		while (curB != null) {
			curB = curB.next;
			lenB++;
		}
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				headA = headA.next;
			}
		} else if (lenA < lenB) {
			for (int i = 0; i < lenB - lenA; i++) {
				headB = headB.next;
			}
		}
		while (headA != null) {
			if (headA == headB) {
				return headA;
			} else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		
		return null;
	}
}
