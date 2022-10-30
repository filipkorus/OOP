package lab4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounterPane {

	public static void main(String[] args) throws IOException {
		String filename = JOptionPane.showInputDialog("Podaj nazwę pliku: ");

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
