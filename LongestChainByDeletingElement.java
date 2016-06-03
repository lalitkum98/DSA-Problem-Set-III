package ProblemSetIII;

public class LongestChainByDeletingElement {

	public boolean findWordDictionary(String str) {
		if (str.equals("a")) {
			return true;
		} else if (str.equals("b")) {
			return true;
		} else if (str.equals("ba")) {
			return true;
		} else if (str.equals("bca")) {
			return true;
		} else if (str.equals("bda")) {
			return true;
		} else if (str.equals("c")) {
			return true;
		} else if (str.equals("bdca")) {
			return true;
		} else {
			return false;
		}

	}
	
	public int findLogestChain(String str, int value,int max) {

		for (int i = 0; i < str.length(); i++) {
			StringBuffer sb = new StringBuffer(str);
			String newstr = sb.deleteCharAt(i).toString();
			if (findWordDictionary(newstr)) {
				max= findLogestChain(newstr, value + 1,max);
			}
		}
		if (value > max)
			max = value;
		return max;
	}

	public static void main(String arg[]) {
		LongestChainByDeletingElement cd = new LongestChainByDeletingElement();
		System.out.println(cd.findLogestChain("bdca", 1,0));
	}
}
