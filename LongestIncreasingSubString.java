package ProblemSetIII;

public class LongestIncreasingSubString {
	// using Dynamic Programmig
	public String findLIS(int arr[]) {
		int tempArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			tempArr[i] = 1;
		for (int i = 1, j = 0; i < arr.length; i++, j++) {
			if (arr[i] > arr[j]) {
				tempArr[i] = tempArr[j] + 1;
			}
		}
		// find max in array
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (tempArr[i] > max)
				max = tempArr[i];
		}

		return "LIS is : " + max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int arr[] ={3,4,-1,0,6,2,3};
		int arr[] = { 3, 4, 1, 2, 3, 0, 1, 2, 3, 4 };
		LongestIncreasingSubString lis = new LongestIncreasingSubString();
		System.out.println(lis.findLIS(arr));
	}

}
