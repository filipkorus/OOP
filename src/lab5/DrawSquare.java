package lab5;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DrawSquare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert size: ");
		int size = 0;
		try {
			size = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException");
			System.exit(1);
		}

		if (size <= 0) {
			System.out.println("Size must be greater than 0.");
			System.exit(1);
		}

		for (int i = 0; i < size; ++i) { System.out.print("#"); }
		System.out.println();

		for (int i = 0; i < size; ++i) {
			System.out.print("#");
			for (int j = 0; j < size - 2; ++j) { System.out.print(" "); }
			System.out.println("#");
		}
		for (int i = 0; i < size; ++i) { System.out.print("#"); }
	}
}
