package ProblemSetIII;

public class LongestIncreasingSubsequence {
	// using Dynamic Programmig
	public String findLIS(int arr[]) {
		int tempArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			tempArr[i] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && tempArr[i] <= tempArr[j]) {
					tempArr[i] = tempArr[j] + 1;
				}
			}
		}
		return "LIS is : " + tempArr[arr.length - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		// int arr[] ={3,4,1,2,3,0,1,2,3,4};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.findLIS(arr));
	}

}
