package day5;

/**
 * @author hainm2
 * Interface for Soldier
 */
public interface Soldier {
	// Return the shot strength
    public int hit();
    
    // Return the defend the hit of certain strength
    public boolean defend(int force);
}