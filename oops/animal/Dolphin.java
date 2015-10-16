package animal;

public class Dolphin extends Animal {

	public Dolphin() {
		this.setTail(false);
	}

	@Override
	public String toString() {
		String ret = "{\n";
		ret += "\t\"Name\": \"" + this.getName() + "\"";
		ret += ",\n\t\"Voice\": \"" + this.getVoice() + "\"";
		ret += ",\n\t\"SpeedMph\": \"" + this.getSpeedMph() + "\"";
		ret += ",\n\t\"Gender\": \"" + this.getGender() + "\"";
		ret += ",\n\t\"Tail\": \"" + (this.getTail() ? "Yes" : "No") + "\"";
		ret += "\n}";
		return ret;
	}

	@Override
	public String talk() {
		String ret = super.talk();
		ret += (this.getTail() ? " I've tail." : " I don't have tail.");
		return ret;
	}

}