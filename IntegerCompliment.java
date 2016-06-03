package ProblemSetIII;

public class IntegerCompliment {
	public int pow(int val, int powe) {
		int value = 0;
		if (powe == 0)
			return 1;
		value = val * pow(val, powe - 1);
		return value;
	}

	public String convertToBinary(int a) {
		StringBuffer sb = new StringBuffer();
		if (a == 1)
			return "1";
		while (a != 1) {
			if (a % 2 == 0) {
				sb.append(0);
				a = a / 2;
			} else {
				sb.append(1);
				a = (a - 1) / 2;
			}

		}
		sb.append(1);
		return sb.reverse().toString();
	}

	public int findComp(int value) {
		int count = 0;
		int newValue = 0;

		// String bValue = Integer.toBinaryString(value);
		String bValue = convertToBinary(value);
		System.out.println(bValue);
		for (int i = bValue.length() - 1; i >= 0; i--) {
			// for complement checking 0 instead of 1
			if (bValue.charAt(i) == '0') {
				newValue = newValue + pow(2, count);
			}
			count++;
		}
		return newValue;
	}

	public static void main(String arg[]) {
		IntegerCompliment ic = new IntegerCompliment();
		System.out.println(ic.findComp(36));
		// System.out.println(ic.convertToBinary(9));

	}
}
