package bots;

import java.util.LinkedList;

import mechanics.*;

public class WaveBot extends Bot {

	public String name(){
		return "Wave";
	}
	
	public LinkedList<Integer> fireRocket(Rocket[][] g){
		LinkedList<Integer> moves = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++){
			moves.push(0);
		}
		curSlot = (curSlot + 1)%3;
		return moves;
	}

}
