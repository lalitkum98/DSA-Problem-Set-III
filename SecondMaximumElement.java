package ProblemSetIII;

public class SecondMaximumElement {
	// In a single loop was the condition
	public int findMaxSecondLargest(int array[]) {
		int max = 0;
		int secondLargestMax = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				secondLargestMax = max;
				max = array[i];
			}

		}
		return secondLargestMax;
	}

	public static void main(String arg[]) {
		int array[] = { 4, 2, 7, 3, 33, 5, 1 };
		SecondMaximumElement boa = new SecondMaximumElement();
		System.out.println(boa.findMaxSecondLargest(array));
	}
}
