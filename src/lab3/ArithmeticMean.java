package lab3;

public class ArithmeticMean {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(1);
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
		int arithmeticMean = sum / args.length;
		int reminder = sum % arithmeticMean;
		System.out.println("Średnia arytmetyczna liczb: " + String.join(", ", args) + " wynosi " + arithmeticMean + (reminder == 0 ? "" : ", reszta: " + reminder));
	}
}
