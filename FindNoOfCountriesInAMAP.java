package ProblemSetIII;

public class FindNoOfCountriesInAMAP {
	// no optimization needed for this
	public int countCountries(int[][] countriesMap, int[][] visit) {
		int numberofCountries = 0;
		for (int i = 0; i < countriesMap.length; i++) {
			for (int j = 0; j < countriesMap[0].length; j++) {
				if (visit[i][j] != 1) {
					boolean value = findCountries(countriesMap, visit, i, j,
							countriesMap[i][j]);
					if (value == true) {
						numberofCountries++;
					}
				}
			}

		}
		return numberofCountries;
	}

	public boolean findCountries(int[][] countriesMap, int[][] visit, int i,
			int j, int value) {

		if (i < 0 || j < 0 || j >= countriesMap[0].length
				|| i >= countriesMap.length) {
			return false;
		}
		if (countriesMap[i][j] != value) {
			return false;
		}
		if (visit[i][j] == 1) {
			return false;
		} else {
			visit[i][j] = 1;
		}
		findCountries(countriesMap, visit, i, j + 1, value);
		findCountries(countriesMap, visit, i + 1, j, value);
		findCountries(countriesMap, visit, i, j - 1, value);
		findCountries(countriesMap, visit, i - 1, j, value);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 },
				{ 3, 3, 4 }, { 1, 4, 4 }, { 4, 1, 1 }

		};
		int[][] visit = new int[A.length][A[0].length];
		FindNoOfCountriesInAMAP boa = new FindNoOfCountriesInAMAP();
		// It should return 11 countries as per question
		System.out.println("No of countries in map : "
				+ boa.countCountries(A, visit));

	}

}
