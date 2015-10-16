package animal;

public class Animal {

	private String name = "not set";
	private String voice = "not set";
	private int legs = 0;
	private int hands = 0;
	private int running_speed_mph = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getHands() {
		return hands;
	}

	public void setHands(int hands) {
		this.hands = hands;
	}

	public int getRunningSpeedMph() {
		return running_speed_mph;
	}

	public void setRunningSpeedMph(int running_speed_mph) {
		this.running_speed_mph = running_speed_mph;
	}

	public String talk() {
		String ret = "I'm " + this.getName() + " " + this.getClass().getName() + "!";
		ret += " My voice is " + this.getVoice();
		ret += " and I run as fast as " + this.getRunningSpeedMph() + " Mph";
		return ret;
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"Legs\": \"" + this.getLegs() + "\"";
		ret += ",\n\t\"Hands\": \"" + this.getHands() + "\"";
		ret += ",\n\t\"RunningSpeedMph\": \"" + this.getRunningSpeedMph() + "\"";
		ret += "\n}";
		return ret;
	}
}