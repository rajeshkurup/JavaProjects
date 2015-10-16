package animal;

public class Kangaroo extends Animal {

	@Override
	public String talk() {
		String ret = "I'm " + this.getName();
		ret += " Kangaroo! My voice is " + this.getVoice();
		ret += " and I run as fast as " + this.getRunningSpeedMph() + " Mph";
		return ret;
	}
}