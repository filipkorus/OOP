package lab3;

import java.util.Calendar;

public class TestClass {
	private final long createdAt;
	private static int count = 0;
	private final int id;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(1);
		}

		int instancesToCreate = Integer.parseInt(args[0]);
		for (int i = 0; i < instancesToCreate; ++i) {
			TestClass tmp = new TestClass();
			System.out.printf("%2d. [%d]\n", tmp.getId(), tmp.getCreatedAt());
		}

		System.out.printf("\nLiczba obieków: %d\n", count);
	}

	TestClass() {
		++count;
		this.id = count;
		this.createdAt = Calendar.getInstance().getTimeInMillis();
	}

	public long getCreatedAt() {
		return this.createdAt;
	}

	public int getId() {
		return this.id;
	}
}
