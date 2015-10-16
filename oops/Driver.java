import animal.*;

class Driver {

	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal);
		System.out.println(animal.talk());

		Cat cat = new Cat();
		cat.setName("Bob");
		cat.setVoice("Meou");
		cat.setLegs(4);
		cat.setRunningSpeedMph(5);
		System.out.println(cat);
		System.out.println(cat.talk());

		Dog dog = new Dog();
		dog.setName("Jimmy");
		dog.setVoice("Wof");
		dog.setLegs(4);
		dog.setRunningSpeedMph(10);
		System.out.println(dog);
		System.out.println(dog.talk());

		Kangaroo kangaroo = new Kangaroo();
		kangaroo.setName("Roger");
		kangaroo.setVoice("Hehe");
		kangaroo.setLegs(2);
		kangaroo.setHands(2);
		kangaroo.setRunningSpeedMph(15);
		System.out.println(kangaroo);
		System.out.println(kangaroo.talk());	
	}

}