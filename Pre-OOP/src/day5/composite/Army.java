package day5.composite;

public class Army extends CompositeSoldier {
	private String name = "";
    public Army() {
        super();
    }
    
    public Army(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    @Override
    public String toString() {
    	return this.getName();
    }
    
}