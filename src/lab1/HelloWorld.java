package lab1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Podaj imie: ");
		String name = inputScanner.nextLine();

		System.out.println("Witaj, " + name + "! Teraz jest: " + new SimpleDateFormat(  "yyyy.MM.dd hh:mm a").format(Calendar.getInstance().getTime()));
	}
}
