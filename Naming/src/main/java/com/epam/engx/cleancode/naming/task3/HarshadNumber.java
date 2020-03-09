package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {
	public static void main(String[] args) {
		long calculationLimit = 1000;
		for (int i = 1; i <= calculationLimit; i++) {
			if (i % countDigitsSum(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int countDigitsSum(int number) {
		int digitsSum = 0;
		while (number != 0) {
            digitsSum += number % 10;
            number = number / 10;
        }
		return digitsSum;
	}
}

