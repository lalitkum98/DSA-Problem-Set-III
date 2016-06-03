package ProblemSetIII; 

public class AddNumberWithoutUsingOperator {

	public int add(int a,int b)
	{
	    int sum,carry; 
	    if (b == 0) return a;
	    sum = a ^ b; // add without carrying 2 - 0010 , 3- 0011  = 0001
	    System.out.println("sum after XOR" + sum );
	    carry = (a & b) << 1; // carry, but don’t add for AND 0010 shift 0100
	    System.out.println("carry after AND & shifting :"  +carry);
	    return add(sum,carry);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddNumberWithoutUsingOperator anw = new AddNumberWithoutUsingOperator();
		System.out.println(anw.add(2, 3));
	}

}
