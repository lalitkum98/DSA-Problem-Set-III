package ProblemSetIII;

import java.util.HashMap;

public class SumPairEqualXIncludeRotatedCase {

	public int findSumPair(int array[], int x) {

		for (int i = 0, j = array.length - 1; i < j;) {
			if (array[i] + array[j] == x) {
				i++;
				j--;
				return 1;
			} else if (array[i] + array[j] < x) {
				i++;
			} else if (array[i] + array[j] > x) {
				j--;
			}
		}
		return 0;

	}

	public boolean isSumXInRotatedArray(int arr[], int sum) {
		int i = 0;
		while (arr[i] < arr[i + 1] && i < arr.length) {
			i++;
		}
		int j = i + 1;

		while (i != j) {
			if (j == arr.length) {
				j = 0;
			}
			if (arr[i] + arr[j] == sum) {
				return true;
				// check less and more
			} else if (arr[i] + arr[j] < sum) {
				j++;

			} else if (arr[i] + arr[j] > sum) {
				i--;
			}

		}
		return false;
	}

	public void isSumPossible(int[] a, int N) {

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int i = 0; i < a.length; i++) {
			map.put(N - a[i], true);
		}

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]) && map.get(a[i])) {
				System.out.println(a[i] + ":" + (N - a[i]));
				map.put(a[i], false);
				map.put(N - a[i], false);

			}
		}
	}

	public static void main(String arg[]) {
		// sort the array if not
		// int array[] = {5,7,9,17,28,19};
		// int array[] = {1,2,3,4,5,6,7};
		int array[] = { 1, 5, 11, 5 };
		int arr[] = { 4, 6, 10, 11, 20, 0, 2 };
		SumPairEqualXIncludeRotatedCase ape = new SumPairEqualXIncludeRotatedCase();
		System.out.println(ape.findSumPair(array, 9));
		ape.isSumPossible(array, 6);

		System.out.println(ape.isSumXInRotatedArray(arr, 26));
	}

}
