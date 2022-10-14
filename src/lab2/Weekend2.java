package lab2;

import java.util.Calendar;

public class Weekend2 {
	private final static String daysOfWeek[] = {"niedziela", "poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota"};

	public static void main(String[] args) {
		int dayNumber = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;

		if (dayNumber == 0 || dayNumber == 6) {
			System.out.println("Mamy weekend!");
		} else {
			int daysToWeekend = Math.max(5 - dayNumber, 0);
			System.out.println("Dziś " + daysOfWeek[dayNumber] + ", do weekendu pozostał" + getSuffixByDayNumber(daysToWeekend) + " " + daysToWeekend + " " + (daysToWeekend == 1 ? "dzień" : "dni") + ".");
		}
	}

	public static String getSuffixByDayNumber(int dayNumber) {
		// pozostal(o) -> 0, 5, 6
		// pozosyal() -> 1
		// pozostal(y) 2, 3, 4

		if (dayNumber == 0 || dayNumber == 5 || dayNumber == 6) {
			return "o";
		} else if (dayNumber == 2 || dayNumber == 3 || dayNumber == 4) {
			return "y";
		}
		return "";
	}
}
