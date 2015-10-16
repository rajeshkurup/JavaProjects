import animal.*;

class Driver {

	public static void main(String[] args) {
		Animal[] animals = new Animal[3];

		animals[0] = new Cat();
		animals[0].setName("Bob");
		animals[0].setVoice("Meou");
		animals[0].setLegs(4);
		animals[0].setRunningSpeedMph(5);

		animals[1] = new Dog();
		animals[1].setName("Jimmy");
		animals[1].setVoice("Wof");
		animals[1].setLegs(4);
		animals[1].setRunningSpeedMph(10);

		animals[2] = new Kangaroo();
		animals[2].setName("Roger");
		animals[2].setVoice("Hehe");
		animals[2].setLegs(2);
		animals[2].setHands(2);
		animals[2].setRunningSpeedMph(15);

		for(Animal animal : animals) {
			System.out.println(animal);
			System.out.println(animal.talk());
		}
	}

}