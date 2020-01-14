package day5;

abstract class AbstractSoldier implements Soldier {
    private int life;

    AbstractSoldier(int life) {
        this.life = life;
    }  
              
    public boolean defend(int force) {
    	if (force <= 0)
    		return true;
        life = (life > force) ? life - force : 0;
        return life > 0;
    }
}