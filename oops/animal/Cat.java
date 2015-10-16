package animal;

public class Cat extends Animal {

	public Cat() {
		this.setLegs(4);
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"Legs\": \"" + this.getLegs() + "\"";
		ret += ",\n\t\"SpeedMph\": \"" + this.getSpeedMph() + "\"";
		ret += "\n}";
		return ret;
	}

}