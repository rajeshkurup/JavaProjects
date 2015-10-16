package animal;

public class Dog extends Animal {

	@Override
	public String toString() {
		return "{\n\t \"ClassName\": \"Dog\" \n}\n" + super.toString();
	}
}