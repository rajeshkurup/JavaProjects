package animal;

public class Cat extends Animal {

	public Cat() {
		this.setLegs(4);
		this.setTail(true);
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"Legs\": \"" + this.getLegs() + "\"";
		ret += ",\n\t\"SpeedMph\": \"" + this.getSpeedMph() + "\"";
		ret += ",\n\t\"Gender\": \"" + this.getGender() + "\"";
		ret += ",\n\t\"Tail\": \"" + (this.getTail() ? "Yes" : "No") + "\"";
		ret += "\n}";
		return ret;
	}

	@Override
	public String talk() {
		String ret = "I'm " + this.getName() + " of type " + this.getClass().getName();
		ret += "! I'm a " + this.getGender();
		ret += ". My voice is " + this.getVoice();
		ret += " and my speed is " + this.getSpeedMph() + " Mph.";
		ret += " I've " + this.getLegs() + " legs.";
		ret += (this.getTail() ? " I've tail." : " I don't have tail.");
		return ret;
	}

	@Override
	public void draw() {
		System.out.println("Draw Cat");
	}

}