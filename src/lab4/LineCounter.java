package lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(1);
		}

		String filename = args[0];
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();

		System.out.println("Liczba wierszy w pliku " + filename + " wynosi: " + lines);
	}

}
