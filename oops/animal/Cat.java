package animal;

public class Cat extends Animal {

	@Override
	public String toString() {
		return "{\n\t \"ClassName\": \"Cat\" \n}\n" + super.toString();
	}
}