package mechanics;

import java.util.LinkedList;


public class Bot {

	public String name(){
		return "Default";
	}
	
	private boolean[] slots = {true, true, true};
	public int curSlot = 1;
	
	public LinkedList<Integer> fireRocket(Rocket[][] g){ return null;}
	
	protected final void destroySlot(int i){
		slots[i] = false;
	}
	
	protected final boolean getSlot(int i){
		return slots[i];
	}
	
	protected final boolean viableShot(){
		return slots[curSlot];
	}
}
