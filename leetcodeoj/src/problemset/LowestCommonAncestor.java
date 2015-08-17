package problemset;

import common.TreeNode;

public class LowestCommonAncestor {
	public TreeNode solution(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null) return null;
		
		if ((root == p) || (root == q)) return root;
		
		TreeNode lcaLeft = solution(root.left, p, q);
		TreeNode lcaRight = solution(root.right, p, q);
		
		if ((lcaLeft != null) && (lcaRight != null)) return root;
		
		return (lcaLeft != null) ? lcaLeft : lcaRight;
	}
}
