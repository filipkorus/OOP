package lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("No arguments were presented.");
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
			wordCount += line.split(" ").length;
			charCount += line.length();
		}

		reader.close();

		String arguments = getArgString(args);
		boolean l = arguments.contains("l"),
				  c = arguments.contains("c"),
				  w = arguments.contains("w");

		if (!(l || c || w)) {
			l = w = c = true;
		}

		if (l) { System.out.println("line count: " + lineCount); }

		if (c) { System.out.println("char count: " + charCount); }

		if (w) { System.out.println("word count: " + wordCount); }
	}

	private static String getArgString(String[] args) {
		String argString = "";
		for (String arg : args) {
			if (!arg.startsWith("-")) { continue; }
			for (int i = 1; i < arg.length(); ++i) { argString += arg.charAt(i); }
		}
		return argString;
	}

	private static String getFilename(String[] args) {
		for (String arg : args) {
			if (!arg.startsWith("-")) { return arg; }
		}
		return null;
	}
}
