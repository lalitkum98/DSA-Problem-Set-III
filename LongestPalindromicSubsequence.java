package ProblemSetIII;

public class LongestPalindromicSubsequence {

	public String findLPS(String str) {
		int tempArr[][] = new int[str.length()][str.length()];
		for (int i = 0, j = 0; i < str.length(); i++, j++)
			tempArr[i][j] = 1;

		for (int l = 1, k = str.length() - 1; k > 0; k--, l++) {
			for (int i = 0, j = l; i < k; i++, j++) {
				if (str.charAt(i) == str.charAt(j)) {
					tempArr[i][j] = 2 + tempArr[i + 1][j - 1];
				} else {
					tempArr[i][j] = Math.max(tempArr[i][j - 1],
							tempArr[i + 1][j]);
				}
			}
		}
		return "LPS is :" + tempArr[0][str.length() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String str = "agbdba";
		String str = "aabdbaa";
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.findLPS(str));
	}

}
