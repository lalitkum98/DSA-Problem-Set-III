package ProblemSetIII;

public class ArraySumEqualSubsetPartition {

	// using recursion
	public boolean isSubsetSum(int array[], int n, int sum) {
		if (n == 0 && sum != 0)
			return false;
		if (sum == 0)
			return true;
		// if last greater ignore
		if (array[n - 1] > sum)
			return isSubsetSum(array, n - 1, sum);

		return isSubsetSum(array, n - 1, sum)
				|| isSubsetSum(array, n - 1, sum - array[n - 1]);
	}

	public boolean isSumEqualSubset(int array[]) {
		int sum = 0;
		boolean ret = false;

		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		if (sum % 2 == 0) {
			ret = isSubsetSum(array, array.length, sum / 2);
		}
		return ret;
	}

	// using DP approach
	public boolean findSumSubset(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		if (sum % 2 != 0)
			return false;

		boolean temp[][] = new boolean[sum / 2][array.length];
		// System.out.println(temp.length);
		for (int i = 0; i < temp[0].length; i++) {
			temp[0][i] = true;
		}
		for (int i = 1; i < temp.length; i++) {
			temp[i][0] = false;
		}

		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				temp[i][j] = temp[i][j - 1];
				if (i >= array[j - 1]) {
					temp[i][j] = temp[i][j] || temp[i - array[j - 1]][j - 1];
				}
			}
		}

		return temp[(sum / 2) - 1][array.length - 1];
	}

	public static void main(String arg[]) {
		int array[] = { 1, 5, 11, 5 };
		// int array[] ={3, 1, 5, 9, 12};

		ArraySumEqualSubsetPartition asp = new ArraySumEqualSubsetPartition();
		System.out.println(asp.isSumEqualSubset(array));
		System.out.println(asp.findSumSubset(array));

	}
}
