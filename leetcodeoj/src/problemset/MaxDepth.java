package problemset;

import common.TreeNode;

public class MaxDepth {
	public int solution(TreeNode root)
	{
		if (root == null) return 0;
		
		int leftDepth = solution(root.left);
		int rightDepth = solution(root.right);
		
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public void test()
	{
		int[] nodeList = {1, 2, 3, 4, 6, 8, 13, 17};
		
		TreeNode root = TreeNode.genTree(nodeList);
		root.printTree();
		
		System.out.println(solution(root));
	}
}
