package day5.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import day5.Soldier;

public class CompositeSoldier implements Soldier {
	protected List<Soldier> listSoldier;

    public CompositeSoldier() {
        listSoldier = new ArrayList<Soldier>();
    }
    
    public void addSoldier(Soldier s) {
    	listSoldier.add(s);
    }

	@Override
	public int hit() {
		int totalHit = 0;
		for (Soldier s: listSoldier) {
			if (s != null)
				totalHit += s.hit();
		}
		return totalHit;
	}

	@Override
	public boolean defend(int force) {
		int damage = (int) Math.ceil(force / listSoldier.size());
        boolean checkDefend = false;
        Iterator<Soldier> iter = listSoldier.iterator();

        while (iter.hasNext()) {
            Soldier s = iter.next();
            if (s.defend(damage))
                checkDefend = true;
            else 
            	iter.remove();         
        }
        
//        for (Soldier s: listSoldier) {
//        	if (s.defend(damage))
//                checkDefend = true;
//            else 
//            	listSoldier.remove(s);
//        }
        
        
        return checkDefend;
	}

}
