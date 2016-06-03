package ProblemSetIII;

public class LongestCommonAncestorLCA {
	// the other way is storing into the array each path and check if any value
	// is common
	static class Tree {
		int value;
		Tree left;
		Tree right;
	}

	public int LCA(Tree root, Tree a, Tree b) {
		if (root == null)
			return 0;
		// If the root is one of a or b, then it is the LCA
		if (root.value == a.value || root.value == b.value)
			return root.value;

		int left = LCA(root.left, a, b);
		int right = LCA(root.right, a, b);

		// If both nodes lie in left or right then their LCA is in left or
		// right,
		// Otherwise root is their LCA
		if (left != 0 && right != 0)
			return root.value;

		return (left != 0) ? left : right;
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
		tr.left.right.left = (new Tree());
		tr.left.right.right = (new Tree());
		tr.left.right.left.value = 19;
		tr.left.right.right.value = 21;
		return tr;
	}

	public static void main(String arg[]) {
		LongestCommonAncestorLCA lca = new LongestCommonAncestorLCA();
		Tree root = lca.createTree();
		Tree a = new Tree();
		a.value = 25;
		Tree b = new Tree();
		b.value = 41;
		System.out.println(lca.LCA(root, a, b));
	}

}
