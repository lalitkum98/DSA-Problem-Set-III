package ProblemSetIII;

public class MatrixPushALLZeorsRightmost {

	public void shiftZerosModified(int matrix[][]) {

		for (int i = 0; i < matrix.length; i++) {
			int k = matrix[0].length - 1;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					while (matrix[i][k] != 0 && j < k) {
						matrix[i][j] = matrix[i][k];
						matrix[i][k] = 0;
						k--;
						break;
					}
				}
			}
		}
	}

	public static void main(String arg[]) {
		int matrix[][] = { { 1, 0, 0, 3 }, { 0, 0, 0, 3 }, { 0, 0, 3, 3 }, };

		MatrixPushALLZeorsRightmost boa = new MatrixPushALLZeorsRightmost();
		boa.shiftZerosModified(matrix);
	}

}
