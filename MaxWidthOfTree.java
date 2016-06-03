package ProblemSetIII;

//perfect code find the max number of nodes on a level horizontally
public class MaxWidthOfTree {

	class Tree {
		int value;
		Tree left;
		Tree right;
	}

	public int findMaxWidth(Tree root, int max) {
		if (root.left == null && root.right == null || root.right == null
				|| root.left == null)
			return 1;
		int value = findMaxWidth(root.left, max)
				+ findMaxWidth(root.right, max);
		if (value > max) {
			max = value;
		}
		return value;
	}

	public Tree createTree() {
		Tree tr = new Tree();
		tr.value = 22;
		tr.left = (new Tree());
		tr.right = (new Tree());
		tr.left.value = 15;
		tr.right.value = 40;
		tr.left.right = (new Tree());
		tr.left.left = (new Tree());
		tr.left.right.value = 20;
		tr.left.left.value = 12;
		tr.right.left = (new Tree());
		tr.right.right = (new Tree());
		tr.right.left.value = 25;
		tr.right.right.value = 41;
		return tr;
	}

	public static void main(String str[]) {
		int max = 0;
		MaxWidthOfTree boa = new MaxWidthOfTree();
		Tree root = boa.createTree();
		System.out.println(boa.findMaxWidth(root, max));
	}
}
