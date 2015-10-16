public class TestException {

	public static void main(String[] args) {

		try {
			int x = 1/0;
		} catch(ArithmeticException ex) {
			System.out.println("Error: " + ex.toString());
		}
	}
}