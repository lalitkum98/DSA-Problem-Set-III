package ProblemSetIII;

public class MaxSumRotatedArray {

	public int findMaxSubArray(int array[]) {
		int maxSoFar = 0;
		int maxSum = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < array.length * 2; i++) {
			int k = i % array.length;
			maxSum = maxSum + array[k];
			if (maxSum < 0) {
				maxSum = 0;
				start = k + 1;
			} else if (maxSum > maxSoFar) {
				maxSoFar = maxSum;
				end = k;
			}
			if (start == end && i > array.length)
				break;
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		// int array[]={4,-1,5,-3,-1,4};
		int array[] = { -1, 2, -2, 3, -1, 4 };
		MaxSumRotatedArray sams = new MaxSumRotatedArray();
		System.out.println(sams.findMaxSubArray(array));

	}

}
