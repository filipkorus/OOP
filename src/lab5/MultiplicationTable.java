// jak cos to na razie nie uzylem klasy Properties

package lab5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
	private static final int VALUE_MIN = 1;
	private static final int VALUE_MAX = 10;
	private static final int REPEAT_MIN = 4;
	private static final int REPEAT_MAX = 10;
	private static final int PERCENT = 70;
	public static void main(String[] args) {
		double currentPercent = 0.;
		int correctTotal = 0;
		int attemptsTotal = 0;

		for (;;) { // infinite loop
			if (attemptsTotal >= REPEAT_MIN) {
				if (currentPercent >= PERCENT) {
					System.out.printf("Congratulations! You achieved %d%%\n", Math.round(currentPercent));
					break;
				}
				if (attemptsTotal > REPEAT_MAX) {
					System.out.printf("Congratulations! You achieved %d%%\n", Math.round(currentPercent));
					break;
				}
			}

			int n1 = randInt(VALUE_MIN, VALUE_MAX), n2 = randInt(VALUE_MIN, VALUE_MAX);
			System.out.printf("%d * %d = ", n1, n2);

			Scanner scanner = new Scanner(System.in);
			int answear = 0;
			try {
				answear = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("InputMismatchException");
				System.exit(1);
			}

			if (answear == n1 * n2) { ++correctTotal; }
			++attemptsTotal;
			currentPercent = (double)correctTotal / attemptsTotal * 100;
		}
	}

	private static int randInt(int min, int max) {
		Random rn = new Random();
		return rn.nextInt((max - min) + 1) + min;
	}
}
