package common;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Definition for a binary tree node.
public class TreeNode {
	private static final Logger logger = LogManager.getLogger();

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) { val = x; }
	
	private int index;  // starting at 1
//	private int level;   // node location info, the level in which the node is, starting at 0 
//	private int offset;  // node location info, the offset within the level, starting at 0
	private NodeLocation location;
	public TreeNode() {}
	public void setIndex(int x) { index = x; }
	public int getIndex() { return index; }
	public void setLevel(int x) { location.level = x; }
	public int getLevel() { return location.level; }
	public void setOffset(int x) { location.offset = x; }
	public int getOffset() { return location.offset; }
	
	public NodeLocation index2location(int index)
	{
		NodeLocation loc = new NodeLocation();
		int level;
		
		for (level = 1; level < 31; level++) {
			int delimit = 1 << level; // "delimit", is the the first index at each level, equal to 2^level
			if (index < delimit) break;
		}
		loc.level = --level;
		loc.offset = index - (1 << level);
				
		return loc;
	}
	
	public TreeNode insertNode(int index)
	{
		TreeNode tmp;
		int level, offset;
		
		NodeLocation loc = index2location(index);
		level = loc.level;
		offset = loc.offset;
		
		NodeLocation prevLoc = new NodeLocation(level - 1, offset >> 1);
		tmp = obtainNode(prevLoc.toIndex());
		
		if (tmp == null) return null;
		
		if ((offset & 1) == 0) {
			tmp.left = new TreeNode();
			tmp.left.setIndex(index);
			return tmp.left;
		}
		else {
			tmp.right = new TreeNode();
			tmp.right.setIndex(index);
			return tmp.right;
		}
		
	}
	
	public int compDepth()
	{
		if (this == null) return 0;
		int left_depth, right_depth;

		if (this.left != null) left_depth = this.left.compDepth();
		else left_depth = 0;
		if (this.right != null) right_depth = this.right.compDepth();
		else right_depth = 0;

		return (left_depth >= right_depth ? left_depth : right_depth) + 1;
	}
	
	public TreeNode obtainNode(int index)
	{
		TreeNode tmp;
		int level, offset;
		
		NodeLocation loc = index2location(index);
		level = loc.level;
		offset = loc.offset;
		
		tmp = this;
		for (int i = level - 1; i >= 0; i--) {
			int thisBit = (offset >> i) & 1;
			if (thisBit == 0) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
			if (tmp == null) return null;
		}
		
		return tmp;
	}
	
	public boolean existNode(int index)
	{
		return obtainNode(index) == null ? false : true;
	}
	
	public void printTree() {
		int tree_depth = this.compDepth();
		
		for (int i = 0; i < tree_depth; i++) {
			for (int j = 0; j < (1 << i); j++) {
				int index = (1<<i)+j;
				System.out.printf("%5d", this.existNode(index) ? index : -1);
			}
			System.out.println();
		}
	}
	
	public void printTreeNodeVal() {
		int tree_depth = this.compDepth();
		
		for (int i = 0; i < tree_depth; i++) {
			for (int j = 0; j < (1 << i); j++) {
				int index = (1<<i)+j;
				TreeNode thisNode = obtainNode(index);
				System.out.printf("%5d", thisNode == null ? -99 : thisNode.val);
			}
			System.out.println();
		}
	}
	
	public static TreeNode genTree(int[] indexList)
	{
		TreeNode root = new TreeNode();
		root.setIndex(1);
		
		Arrays.sort(indexList);
		if (indexList[0] != 1) return null;
		
		for (int i = 1; i < indexList.length ;i++) {
			root.insertNode(indexList[i]);
		}
		
		return root;
	}

	public static TreeNode genTree(int[] indexList, int[] valueList)
	{
		TreeNode root = new TreeNode();
		root.setIndex(1);
		
		ArrayIndexComparator aic = new ArrayIndexComparator(indexList);
		Integer[] indices = aic.createIndexArray();
		Arrays.sort(indices, aic);
//		for (int i = 0; i < indices.length; i++) {
//			System.out.format("%4d", indices[i]);
//		}
//		System.out.println();
		
		if (indexList[indices[0]] != 1) return null;
		root.val = valueList[indices[0]];
		
		TreeNode newNode;
		for (int i = 1; i < indexList.length ;i++) {
			newNode = root.insertNode(indexList[indices[i]]);
			newNode.val = valueList[indices[i]];
		}
		
		return root;
	}
}
