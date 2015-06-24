package bots;

import java.util.LinkedList;
import java.util.Random;

import mechanics.*;


public class WallE extends Bot {

	int turn = 2;
	
	public String name(){
		return "Wall-E";
	}
	
	public LinkedList<Integer> fireRocket(Rocket[][] g){
		turn++;
		LinkedList<Integer> moves = new LinkedList<Integer>();
		curSlot = 1;
		switch(turn%4){
		case 0: 
			//Check the right wall
			if(getSlot(2)){
				curSlot = 2;
				moves.push(1);
				return moves;
			}
		case 1:
			//Check the left wall
			if(getSlot(0)){
				curSlot = 0;
				moves.push(7);
				return moves;
			}
		case 2:
			//Check the center wall
			if(getSlot(1)){
				curSlot = 1;
				moves.push(0);
				return moves;
			}
			break;
		default:
			//Fire a sneaky rocket
			Random rand = new Random();
			int direction = rand.nextInt(2);
			int back = 0;
			if(direction == 0 && getSlot(2)){ direction = 1; back = 7; curSlot = 2;}
			else{ direction = 7; back = 1; curSlot = 0; }
			moves.push(0);
			moves.push(direction);
			moves.push(direction);
			for(int i = 0; i < 5; i++){
				moves.push(0);
			}
			
			//Go for the center after turn 100
			if(turn > 104){
				moves.pop();
				moves.push(back);
			}
			moves.push(back);
			moves.push(back);
			
			
		}
		
		return moves;
		
		
		
		
		
		
		
		
		
		
	}

}
