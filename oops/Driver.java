import animal.*;

class Driver {

	public static void main(String[] args) {
		Animal[] animals = new Animal[5];

		animals[0] = new Cat();
		animals[0].setName("Bob");
		animals[0].setVoice("Meou");
		animals[0].setSpeedMph(5);

		animals[1] = new Dog();
		animals[1].setName("Jimmy");
		animals[1].setVoice("Wof");
		animals[1].setSpeedMph(10);

		animals[2] = new Kangaroo();
		animals[2].setName("Roger");
		animals[2].setVoice("Hehe");
		animals[2].setSpeedMph(15);

		animals[3] = new SeaLion();
		animals[3].setName("Michele");
		animals[3].setVoice("Ghhhrrrr");
		animals[3].setSpeedMph(20);

		animals[4] = new Dolphin();
		animals[4].setName("Mary");
		animals[4].setVoice("Pheu");
		animals[4].setSpeedMph(25);

		for(Animal animal : animals) {
			System.out.println(animal);
			System.out.println(animal.talk());
		}
	}

}