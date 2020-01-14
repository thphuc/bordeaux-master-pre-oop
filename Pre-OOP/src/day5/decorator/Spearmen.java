package day5.decorator;

import day5.Infantrymen;
import day5.Soldier;
import day5.equipment.LightArmor;
import day5.equipment.MediumShield;
import day5.equipment.Pike;

public class Spearmen extends DecoratorSoldier{

	public Spearmen(Soldier soldier) {
		super(soldier);	
	}
	
	public Spearmen(int life) {
		super(createSpearmen(life));
	}
	
	private static Soldier createSpearmen(int life) {
		Soldier temp1 = new DecoratorSoldier(new Infantrymen(life));
		((DecoratorSoldier)temp1).addEquipment(new MediumShield());
		Soldier temp2 = new DecoratorSoldier(temp1);
		((DecoratorSoldier)temp1).addEquipment(new LightArmor());
		Soldier result = new DecoratorSoldier(temp2);
		((DecoratorSoldier)result).addEquipment(new Pike());
		return result;
	}
	
	@Override
	public String toString() {
		return "Spearmen";
	}
	

}
