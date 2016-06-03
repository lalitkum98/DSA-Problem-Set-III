package ProblemSetIII;

public class LongestPalindromicSubstring {

	public String findLPS(String str) {
		int tempArr[][] = new int[str.length()][str.length()];
		for (int i = 0, j = 0; i < str.length(); i++, j++)
			tempArr[i][j] = 1;

		for (int l = 1, k = str.length() - 1; k > 0; k--, l++) {
			for (int i = 0, j = l; i < k; i++, j++) {
				if (str.charAt(i) == str.charAt(j)) {
					// one case will false where in ss or a so it will return 2
					// always
					tempArr[i][j] = 2 + tempArr[i + 1][j - 1];
				} else {

					tempArr[i][j] = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = 0; j < tempArr[0].length; j++) {
				if (tempArr[i][j] > max)
					max = tempArr[i][j];
			}
		}

		return "LPS is :" + max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String str = "agbdba";
		String str = "aabdbaa";
		// String str = "webccahw";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.findLPS(str));
	}

}
