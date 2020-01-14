package day5.decorator;

import day5.Soldier;
import day5.equipment.Equipment;

/**
 * @author hainm2
 * Implement the Decorator Design Pattern for Soldier
 */
public class DecoratorSoldier implements Soldier{
	private Soldier soldier; 
	private Equipment equipment;
	
	public DecoratorSoldier() {
		super();
	}
	
	public DecoratorSoldier(Soldier soldier) {
		this.soldier = soldier; 
	}
	
	public void addEquipment(Equipment equipment) {
		this.equipment = equipment;		
	}
	
	public Equipment getEquipment() {
		return this.equipment;
	}
 
	@Override
	public int hit() {
		if (equipment != null)
			return soldier.hit() + equipment.getAttackStrength();
		else return soldier.hit();
	}

	@Override
	public boolean defend(int force) {
		if (equipment != null)
			return soldier.defend(force - equipment.getDefendStrength());
		return soldier.defend(force);
	}
}
