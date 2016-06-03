package ProblemSetIII;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindPerferctSquareBetweenGivenRange {

	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		long numbers[] = new long[10];
		System.out
				.println("Please enter the range for perfect sqaure root check : eg : 10 15 :");
		for (int i = 0; stdin.hasNext(); i++) {
			numbers[i] = stdin.nextLong();
			if (i == 1)
				break;
		}
		System.out.println("Perfect square lies between range ");
		for (long j = numbers[0]; j <= numbers[1]; j++) {
			int sqrt = (int) Math.sqrt(j);
			if (sqrt * sqrt == j) {

				System.out.print(j + "\t");
			}
		}

	}

}
