package lab5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
	enum props {
		VALUE_MIN,
		VALUE_MAX,
		PERCENT,
		REPEAT_MIN,
		REPEAT_MAX
	}

	public static void main(String[] args) throws IOException {
		Properties p = getProperties();

		int VALUE_MIN = Integer.parseInt(p.getProperty(props.VALUE_MIN.toString()));
		int VALUE_MAX = Integer.parseInt(p.getProperty(props.VALUE_MAX.toString()));
		int REPEAT_MIN = Integer.parseInt(p.getProperty(props.REPEAT_MIN.toString()));
		int REPEAT_MAX = Integer.parseInt(p.getProperty(props.REPEAT_MAX.toString()));
		int PERCENT = Integer.parseInt(p.getProperty(props.PERCENT.toString()));

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

	private static Properties getProperties() throws IOException {
		Properties properties = new Properties();
		File file = null;
		try {
			file = new File("setup.properties");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		if (!file.exists()) {
			properties.setProperty(props.VALUE_MIN.toString(), "1");
			properties.setProperty(props.VALUE_MAX.toString(), "10");
			properties.setProperty(props.PERCENT.toString(), "70");
			properties.setProperty(props.REPEAT_MIN.toString(), "10");
			properties.setProperty(props.REPEAT_MAX.toString(), "25");

			properties.store(new FileWriter("setup.properties"), "Multiplication Table settings");
		}

		FileReader reader = new FileReader(file);
		properties.load(reader);

		return properties;
	}

	private static int randInt(int min, int max) {
		Random rn = new Random();
		return rn.nextInt((max - min) + 1) + min;
	}
}
