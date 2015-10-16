package animal;

public class Animal {

	private String name = "not set";
	private String voice = "not set";

	private int hands = 0;
	private int legs = 0;
	private int speed_mph = 0;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoice() {
		return this.voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	protected int getHands() {
		return this.hands;
	}

	protected void setHands(int hands) {
		this.hands = hands;
	}

	protected int getLegs() {
		return this.legs;
	}

	protected void setLegs(int legs) {
		this.legs = legs;
	}

	public int getSpeedMph() {
		return this.speed_mph;
	}

	public void setSpeedMph(int speed_mph) {
		this.speed_mph = speed_mph;
	}

	public String talk() {
		String ret = "I'm " + this.getName() + " of type " + this.getClass().getName();
		ret += "! My voice is " + this.getVoice();
		ret += " and my speed is " + this.getSpeedMph();
		ret += " Mph. I've " + this.getLegs() + " legs and " + this.getHands() + " hands.";
		return ret;
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"SpeedMph\": \"" + this.getSpeedMph() + "\"";
		ret += "\n}";
		return ret;
	}
}