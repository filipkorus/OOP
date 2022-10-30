package lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(1);
		}

		String filename = getFilename(args);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		String line;
		int wordCount = 0, lineCount = 0, charCount = 0;

		while((line = reader.readLine()) != null) {
			++lineCount;

			String words[] = line.split(" ");
			wordCount += words.length;

			for (String word : words) {
				charCount += word.length();
			}
		}

		reader.close();

		boolean l = isArg(args, "l"),
				  c = isArg(args, "c"),
				  w = isArg(args, "w");

		if (l || !(l || c || w)) {
			System.out.println("wierszy: " + lineCount);
		}

		if (c || !(l || c || w)) {
			System.out.println("znaków: " + charCount);
		}

		if (w || !(l || c || w)) {
			System.out.println("słów: " + wordCount);
		}
	}

	private static boolean isArg(String[] args, String argToCheck) {
		for (String arg : args) {
			if (!arg.startsWith("-")) {
				continue;
			}
			if (arg.contains(argToCheck)) {
				return true;
			}
		}
		return false;
	}

	private static String getFilename(String[] args) {
		for (String arg : args) {
			if (!arg.startsWith("-")) {
				return arg;
			}
		}
		return null;
	}
}
