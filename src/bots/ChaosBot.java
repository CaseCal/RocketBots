package bots;
import java.util.LinkedList;
import java.util.Random;

import mechanics.*;

public class ChaosBot extends Bot {

	public String name(){
		return "Chaos";
	}
	
	public LinkedList<Integer> fireRocket(Rocket[][] g){
		LinkedList<Integer> moves = new LinkedList<Integer>();
		
		int[] forward = {0,1,2,6,7};
		
		//Get crazy
		Random rand = new Random();
		for(int i = 0; i < 50; i++){
			moves.push(forward[rand.nextInt(5)]);
		}
		super.curSlot = rand.nextInt(3);
		return moves;
		
		
	}
}
