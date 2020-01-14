package day5.decorator;

import day5.Infantrymen;
import day5.Soldier;
import day5.equipment.MediumArmor;
import day5.equipment.MediumShield;
import day5.equipment.Sword;

public class Swordmen extends DecoratorSoldier {
	public Swordmen(int life) {
		super(createSwordmen(life));
	}
	
	private static Soldier createSwordmen(int life) {
		Soldier temp1 = new DecoratorSoldier(new Infantrymen(life));
		((DecoratorSoldier)temp1).addEquipment(new MediumShield());
		Soldier temp2 = new DecoratorSoldier(temp1);
		((DecoratorSoldier)temp1).addEquipment(new MediumArmor());
		Soldier result = new DecoratorSoldier(temp2);
		((DecoratorSoldier)result).addEquipment(new Sword());
		return result;
	}
	
	@Override
	public String toString() {
		return "Swordmen";
	}
}
