package problemset;

import common.TreeNode;

public class IsSameTree {
	public boolean solution(TreeNode p, TreeNode q)
	{
		if ((p == null) && (q == null)) return true;
		if ((p == null) || (q == null)) return false;
		
		if (p.val != q.val) return false;
		if (!solution(p.left, q.left)) return false;
		if (!solution(p.right, q.right)) return false;
		
		return true;
	}
}
