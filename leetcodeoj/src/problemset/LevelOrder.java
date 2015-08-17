package problemset;

import java.util.*;

import common.TreeNode;

public class LevelOrder {
	public List<List<Integer>>solution(TreeNode root) {
		List<List<Integer>> LevelOrderVal = new ArrayList<>();
		Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
		
		if (root == null) return LevelOrderVal;
		treeQ.add(root);
		TreeNode lastNodeInLevel = root, lastNodeNxtLevel = null;
		List<Integer> valInLevel = new ArrayList<Integer>();
		while (!treeQ.isEmpty()) {
			TreeNode curNode = treeQ.remove();
			valInLevel.add(curNode.val);
			if (curNode.left != null) {
				treeQ.add(curNode.left);
				lastNodeNxtLevel = curNode.left;
			}
			if (curNode.right != null) {
				treeQ.add(curNode.right);
				lastNodeNxtLevel = curNode.right;
			}
			if (curNode == lastNodeInLevel) {
				lastNodeInLevel = lastNodeNxtLevel;
				LevelOrderVal.add(valInLevel);
				valInLevel = new ArrayList<Integer>();
			}
		}
		
		return LevelOrderVal;
	}
	
	public List<List<Integer>> solutionBottom(TreeNode root)
	{
		List<List<Integer>> treeLevelList = new ArrayList<>();
		if (root == null) return treeLevelList;
		
		Queue<TreeNode> treeQ = new LinkedList<>();
		treeQ.add(root);
		TreeNode curNode, curRightmostNode = root, nxtRightmostNode = root;
		List<Integer> curLevel = new ArrayList<>();
		Stack<List<Integer>> treeLevelStack = new Stack<>();
		while (!treeQ.isEmpty()) {
			curNode = treeQ.remove();
			curLevel.add(curNode.val);
			if (curNode.left != null) {
				treeQ.add(curNode.left);
				nxtRightmostNode = curNode.left;
			}
			if (curNode.right != null) {
				treeQ.add(curNode.right);
				nxtRightmostNode = curNode.right;
			}
			if (curNode == curRightmostNode) {
				curRightmostNode = nxtRightmostNode;
				treeLevelStack.add(curLevel);
				curLevel = new ArrayList<>();
			}
		}
		
		while (!treeLevelStack.empty()) {
			treeLevelList.add(treeLevelStack.pop());
		}
		
		return treeLevelList;
	}
	
	public void test()
	{
		int[] nodeList = {1, 2, 3, 6, 7};
		int[] valueList = {3, 9, 20, 15, 7};
		
		TreeNode root = TreeNode.genTree(nodeList, valueList);
		root.printTreeNodeVal();
		List<List<Integer>> levelOrderTop = solution(root);
		System.out.println(levelOrderTop);
		List<List<Integer>> levelOrderBottom = solutionBottom(root);
		System.out.println(levelOrderBottom);
	}
}