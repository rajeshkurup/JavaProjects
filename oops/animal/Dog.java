package animal;

public class Dog extends Animal {

	public Dog() {
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
		String ret = super.talk();
		ret += " I've " + this.getLegs() + " legs.";
		ret += (this.getTail() ? " I've tail." : " I don't have tail.");
		return ret;
	}

}