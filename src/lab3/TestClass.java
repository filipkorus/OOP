package lab3;

import java.util.Calendar;

public class TestClass {
	private final long createdAt;
	private final int id;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			System.exit(0);
		}

		int instancesToCreate = Integer.parseInt(args[0]);
		for (int i = 0; i < instancesToCreate; ++i) {
			TestClass tmp = new TestClass();
			System.out.printf("%2d. [%d]\n", i + 1, tmp.getCreatedAt());
		}

		System.out.printf("\nLiczba obieków: %d\n", instancesToCreate);
	}

	TestClass() {
		this.id = 1;
		this.createdAt = Calendar.getInstance().getTimeInMillis();
	}

	public long getCreatedAt() {
		return this.createdAt;
	}
}
