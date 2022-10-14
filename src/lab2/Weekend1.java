package lab2;

import java.util.Date;

public class Weekend1 {
	public static void main(String[] args) {
		Date today = new Date();
		int dayNumber = today.getDay();

		String dayName = "";
		switch (dayNumber) {
			case 1:
				dayName = "poniedziałek";
				break;
			case 2:
				dayName = "wtorek";
				break;
			case 3:
				dayName = "środa";
				break;
			case 4:
				dayName = "czwartek";
				break;
			case 5:
				dayName = "piątek";
				break;
			default:
				dayName = "weekend";
		}

		System.out.println("Dziś jest " + dayName + ".");
	}
}
