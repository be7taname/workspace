package problemset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.TreeNode;

public class IsBalanced {
	private static final Logger logger = LogManager.getLogger();
	
	public int compBalancedDepth(TreeNode node)
	{
		if (node == null) return 0;

		int left_depth = compBalancedDepth(node.left);
		if (left_depth == -1) return -1;
		int right_depth = compBalancedDepth(node.right);
		if (right_depth == -1) return -1;
		if ((left_depth - right_depth < -1) || (left_depth - right_depth > 1)) return -1;
		logger.debug("node value is " + node.val + ": node.left depth is " + left_depth + ", node.right depth is " + right_depth + ".");

		return (left_depth >= right_depth ? left_depth : right_depth) + 1;
	}
	
	public boolean solution(TreeNode root)
	{
		if (root == null) return true;
		
		int left_depth = compBalancedDepth(root.left);
		if (left_depth == -1) return false;
		int right_depth = compBalancedDepth(root.right);
		if (right_depth == -1) return false;
				
		return ((left_depth - right_depth >= -1) && (left_depth - right_depth <= 1));
	}
	
	public void test()
	{
		int[] nodeList = {1, 2, 3, 4, 7, 8, 15};
		
		TreeNode root = TreeNode.genTree(nodeList);
		root.printTree();
		
		System.out.println("This node balancing is " + solution(root));
	}
}
