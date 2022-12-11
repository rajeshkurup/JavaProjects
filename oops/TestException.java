public class TestException {

	public static void divByZero3() {
		int x = 1/0;
		System.out.println(x);
	}

	public static void divByZero2() {
		TestException.divByZero3();
	}

	public static void divByZero() {
		TestException.divByZero2();
	}

	public static void indexOutOfBounds3() {
		int arr[] = new int[1];
		System.out.println(arr[2]);
	}

	public static void indexOutOfBounds2() {
		TestException.indexOutOfBounds3();
	}

	public static void indexOutOfBounds() {
		TestException.indexOutOfBounds2();
	}

	public static void everythingIsFine3() {
		int arr[] = new int[1];
		System.out.println(arr[0]);
		int x = 1/1;
		System.out.println(x);
	}

	public static void everythingIsFine2() {
		TestException.everythingIsFine3();
	}

	public static void everythingIsFine() {
		TestException.everythingIsFine2();
	}

	public static void main(String[] args) {

		try {
			TestException.divByZero();
		} catch(ArithmeticException ex) {
			System.out.println("Error: " + ex);
			ex.printStackTrace();
		} finally {
			System.out.println("Done with Division By Zero!");
		}

		try {
			TestException.indexOutOfBounds();
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Error: " + ex);
			ex.printStackTrace();
		} finally {
			System.out.println("Done with Index Out Of Bounds!");
		}

		try {
			TestException.everythingIsFine();
		} catch(ArithmeticException ex) {
			System.out.println("Error: " + ex);
			ex.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Error: " + ex);
			ex.printStackTrace();
		} finally {
			System.out.println("Everything Is Fine!");
		}
	}
}