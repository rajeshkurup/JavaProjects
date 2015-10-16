package animal;

public class Dog extends Animal {

	@Override
	public String talk() {
		String ret = "I'm " + this.getName();
		ret += " Dog! My voice is " + this.getVoice();
		ret += " and I run as fast as " + this.getRunningSpeedMph() + " Mph";
		return ret;
	}
}