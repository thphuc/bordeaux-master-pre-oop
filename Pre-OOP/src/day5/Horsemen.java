package day5;

public class Horsemen extends AbstractSoldier {
    private static final int FORCE_HORSEMEN = 2;

    public Horsemen(int life) {
        super(life);        
    }

    public int hit() {
        return FORCE_HORSEMEN;
    }
    
    @Override
	public String toString() {
		return "Horsemen";
	}
}