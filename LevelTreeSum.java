package ProblemSetIII;

public class LevelTreeSum {

	class Tree {
		int value;
		Tree left;
		Tree right;
	}

	public void findLevelSum(Tree root, int level, int levelSum[]) {
		if (root == null)
			return;

		levelSum[level] = levelSum[level] + root.value;
		level++;
		findLevelSum(root.left, level, levelSum);
		findLevelSum(root.right, level, levelSum);
		level--;
		if (level == 0) {
			for (int i = 0; i < levelSum.length; i++) {
				if (levelSum[i] != 0)
					System.out.println("Sum of level " + i + "is "
							+ levelSum[i]);
			}

		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int levelSum[] = new int[10];
		LevelTreeSum ts = new LevelTreeSum();
		Tree root = ts.createTree();
		ts.findLevelSum(root, 0, levelSum);

	}

}
