package lab3;

public class FloatArithmeticMean {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(1);
		}

		double sum  = 0;
		for (String arg : args) {
			try {
				double number = Double.parseDouble(arg);
				sum += number;
				System.out.printf("%,15.3f\n", number);
			} catch (NumberFormatException e) {
				System.out.println(arg + " to nie liczba!!");
				System.exit(1);
			}
		}
		System.out.println("---------------");
		System.out.printf("%,15.3f\n\n", sum);

		double arithmeticMean = sum / args.length;
		System.out.printf("Średnia arytmetyczna: %,.4f\n", arithmeticMean);
	}
}
