package animal;

public class Kangaroo extends Animal {

	public Kangaroo() {
		this.setHands(2);
		this.setLegs(2);
		this.setTail(true);
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"Legs\": \"" + this.getLegs() + "\"";
		ret += ",\n\t\"Hands\": \"" + this.getHands() + "\"";
		ret += ",\n\t\"SpeedMph\": \"" + this.getSpeedMph() + "\"";
		ret += ",\n\t\"Gender\": \"" + this.getGender() + "\"";
		ret += ",\n\t\"Tail\": \"" + (this.getTail() ? "Yes" : "No") + "\"";
		ret += "\n}";
		return ret;
	}

	@Override
	public String talk() {
		String ret = super.talk();
		ret += " I've " + this.getLegs() + " legs and " + this.getHands() + " hands.";
		ret += (this.getTail() ? " I've tail." : " I don't have tail.");
		return ret;
	}

	@Override
	public void draw() {
		System.out.println("Kangaroo");
	}

}