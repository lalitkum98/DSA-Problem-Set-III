package ProblemSetIII;

public class MinimumEditDistance {
	int editedElements[][];

	public String findMinEdit(String str1, String str2) {
		int temp[][] = new int[str2.length() + 1][str1.length() + 1];

		for (int i = 0; i <= str2.length(); i++)
			temp[i][0] = i;
		for (int j = 0; j <= str1.length(); j++)
			temp[0][j] = j;

		for (int i = 1; i <= str2.length(); i++) {
			for (int j = 1; j <= str1.length(); j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					temp[i][j] = temp[i - 1][j - 1];
				} else if (str2.charAt(i - 1) != str1.charAt(j - 1)) {
					temp[i][j] = 1 + Math.min(temp[i - 1][j - 1],
							Math.min(temp[i - 1][j], temp[i][j - 1]));
				}
			}
		}
		editedElements = temp;
		return "Min Edit Required :" + temp[str2.length()][str1.length()];
	}

	public void findEditedElment(String str1, String str2) {
		findMinEdit(str1, str2);

		int i = str2.length();
		int j = str1.length();
		while (i >= 1 || j >= 1) {
			if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
				i--;
				j--;

			} else if (str2.charAt(i - 1) != str1.charAt(j - 1)) {

				if (editedElements[i][j] - 1 == editedElements[i - 1][j - 1]) {
					System.out.println("replacing -" + str1.charAt(j - 1)
							+ "with -" + str2.charAt(i - 1));
					i--;
					j--;
				} else if (editedElements[i][j] - 1 == editedElements[i][j - 1]) {
					System.out.println("deletd " + str1.charAt(j - 1));
					j--;
				} else if (editedElements[i][j] - 1 == editedElements[i - 1][j]) {
					System.out.println("deleted " + str2.charAt(i - 1));
					i--;
				}
			}
		}
	}

	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "azced";
		// String str1 ="Hello";
		// String str2 ="ehllkk";
		MinimumEditDistance med = new MinimumEditDistance();
		System.out.println(med.findMinEdit(str1, str2));
		med.findEditedElment(str1, str2);
	}

}
