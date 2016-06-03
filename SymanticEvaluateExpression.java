package ProblemSetIII;

import java.util.Stack;

public class SymanticEvaluateExpression {
	// solve expression "2+((5*5)-2*5)/9"; , working fine for this now
	// 9/11./2015

	public int calculater(int operand1, char operator, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '*':
			return operand1 * operand2;
		case '-':
			return operand1 - operand2;
		case '/':
			if (operand2 == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return operand1 / operand2;

		}
		return 0;
	}

	public int precedence(char ch) {

		switch (ch) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '(':
			return 3;
		case ')':
			return 3;
		}

		return 0;
	}

	public boolean isOperator(char ch) {
		if (ch == '/' || ch == '*' || ch == '-' || ch == '+' || ch == ')'
				|| ch == '(')
			return true;
		else
			return false;
	}

	public Stack<Integer> solveExpression(String str) {
		Stack<Character> stackOperator = new Stack<Character>();
		Stack<Integer> stackOperand = new Stack<Integer>();
		int pointer = 0;
		int flag = 0;
		while (pointer < str.length()) {
			if (isOperator(str.charAt(pointer))) {

				if (stackOperator.isEmpty()
						|| precedence(stackOperator.lastElement()) <= precedence(str
								.charAt(pointer))
						|| stackOperator.lastElement() == '(') {
					if (str.charAt(pointer) == '(') {
						flag++;
					}
					stackOperator.push(str.charAt(pointer));

					if (flag != 0 && str.charAt(pointer) == ')') {
						stackOperator.pop();
						char operator = stackOperator.pop();
						int operand2 = stackOperand.pop();
						int operand1 = stackOperand.pop();
						int value = calculater(operand1, operator, operand2);
						stackOperand.push(value);
						while (stackOperator.lastElement() != '(') {
							char operator1 = stackOperator.pop();
							int operand3 = stackOperand.pop();
							int operand4 = stackOperand.pop();
							int value1 = calculater(operand4, operator1,
									operand3);
							stackOperand.push(value1);
						}
						stackOperator.pop();
						flag--;

					}
					pointer++;
				} else {
					char operator = stackOperator.pop();
					int operand2 = stackOperand.pop();
					int operand1 = stackOperand.pop();
					int value = calculater(operand1, operator, operand2);
					stackOperand.push(value);

				}
			} else {
				stackOperand.push(Integer.valueOf(Character.getNumericValue(str
						.charAt(pointer))));
				pointer++;
			}

		}
		while (!stackOperator.isEmpty()) {
			char operator = stackOperator.pop();
			int operand2 = stackOperand.pop();
			int operand1 = stackOperand.pop();
			int value = calculater(operand1, operator, operand2);
			stackOperand.push(value);
		}
		return stackOperand;
	}

	public static void main(String arg[]) {
		SymanticEvaluateExpression syn = new SymanticEvaluateExpression();
		String str = "2+((5*5)-2*5)/9";
		// String str ="2+5*5-3*5/5";
		System.out.println(syn.solveExpression(str));

	}
}
