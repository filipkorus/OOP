package lab2;

import java.util.Calendar;
import java.util.Date;

public class Weekend {
	public static void main(String[] args) {
		Date today = new Date();
		int dayNumber = today.getDay();
		System.out.println("Liczba dni do weekendu: " + Math.max(5 - dayNumber, 0));
	}
}
