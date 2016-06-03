package ProblemSetIII;

public class PartitionArrayEqually {
	// Recursive solution
	public boolean findPartition(int arr[], int sum, int noOfElements) {
		if (sum == 0)
			return true;

		if (noOfElements == 0 && sum != 0)
			return false;

		return findPartition(arr, sum, noOfElements - 1)
				|| findPartition(arr, sum - arr[noOfElements - 1],
						noOfElements - 1);
	}

	// dynamic approach

	public boolean findPartitionDynamic(int arr[], int sum) {
		boolean tempArr[][] = new boolean[sum + 1][arr.length + 1];
		for (int i = 0; i < arr.length + 1; i++)
			tempArr[0][i] = true;
		for (int i = 1; i < arr.length + 1; i++)
			tempArr[i][0] = false;

		for (int i = 1; i < sum + 1; i++) {
			for (int j = 1; j < arr.length + 1; j++) {
				tempArr[i][j] = tempArr[i][j - 1];
				if (i >= arr[j - 1]) {
					tempArr[i][j] = tempArr[i][j]
							|| tempArr[i - arr[j - 1]][j - 1];
				}
			}
		}
		return tempArr[sum][arr.length];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// please provide even number of elements
		// int arr[] = { 2, 4, 1, 4, 3 };
		int arr[] = { 5, 2, 4, 5 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		sum = sum / 2;
		PartitionArrayEqually pae = new PartitionArrayEqually();
		System.out.println("is Partition exist :"
				+ pae.findPartition(arr, sum, arr.length));
		System.out.println("is Partition exist :"
				+ pae.findPartitionDynamic(arr, sum));

	}

}
