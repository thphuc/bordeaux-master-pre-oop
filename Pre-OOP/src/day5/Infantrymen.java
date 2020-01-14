package day5;

public class Infantrymen extends AbstractSoldier {
    private static final int FORCE_INFANTRYMEN = 1;

    public Infantrymen(int life) {
        super(life);
    }

    public int hit() {
        return FORCE_INFANTRYMEN;
    }
    
    @Override
	public String toString() {
		return "Infantrymen";
	}
}