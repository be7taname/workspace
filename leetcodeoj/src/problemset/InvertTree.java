package problemset;

import common.TreeNode;

public class InvertTree {
	public TreeNode solution(TreeNode root)
	{
		if (root == null) return root;
		else {
			TreeNode tmp;
			tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			if (root.left != null) root.left = solution(root.left);
			if (root.right != null) root.right = solution(root.right);
			
			return root;
		}
	}
	
	public void test()
	{
		int[] nodeList = {4, 5, 7, 3, 1, 2};
		int[] valueList = {1, 3, 9, 7, 4, 2};
		
		TreeNode root = TreeNode.genTree(nodeList, valueList);
		root.printTreeNodeVal();
		solution(root);
		root.printTreeNodeVal();
	}
}
