package lab3;

import java.util.Arrays;

public class ArithmeticMean {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(0);
		}

		int sum  = 0;
		for (String arg : args) {
			try {
				sum += Integer.parseInt(arg);
			} catch (NumberFormatException e) {
				System.out.println(arg + " to nie liczba!!");
				System.exit(1);
			}
		}
		float arithmeticMean = (float)sum / args.length;
		System.out.println("Średnia arytmetyczna liczb: " + String.join(", ", args) + " wynosi " + arithmeticMean);
	}
}
