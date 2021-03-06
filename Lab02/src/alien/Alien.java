package alien;
/*
 * Directions: lab 2 (part B).pdf
 */
public class Alien {
    private int health; // 0=dead, 100=full strength
    private String name;
    private int inflictsDammage = 0;
    
    public Alien(int health, String name) {
        setHealth(health);
        setName(name);
    }
	public String getName(){
		return name;
	}
	public void setName(String name2) {
		name = name2;
	}
	public int getHealth(){
		return health;
	}
	public int getDammage(){
		return 0;
	}
	public void setHealth(int h){
		if ( h <= 0 ){
		    health = 0;
		} else if ( h >= 100 ){
		    health = 100;
		} else {
			health = h;
		}
	}
}