package mechanics;

import java.util.LinkedList;
import java.util.Scanner;

public class Duel {

	static Bot p1;
	static Bot p2;
	static LinkedList<Rocket> rockets;
	static int turns;
	
	public static int[] play(Bot a, Bot b, boolean debug){
		p1 = a;
		p2 = b;
		turns = 0;
		rockets = new LinkedList<Rocket>();

		
		while(!gameOver()){
			
			
			
			//Create current grid
			Grid g = new Grid(rockets, p1, p2);
			
			if(turns%2 == 0){
				//Get new rockets from players
				Rocket rock = new Rocket(p1.fireRocket(g.g), "^", g.g[0].length/2 - 1 + p1.curSlot, -1);
				if(p1.viableShot()){
					rockets.add(rock);
				}
				rock = new Rocket(p2.fireRocket(g.flip().g), "v", g.g[0].length/2 - 1 + p2.curSlot, 9);
				rock.flip();
				if(p2.viableShot()){
					rockets.add(rock);
				}
			}
			
			//Move rockets
			for(Rocket r : rockets){
				//System.out.println("Rocket: x = " + r.xPos + ", y = " + r.yPos + ", dis = " + r.dis + ", turnsDestroyed = " + r.turnsDestroyed + "isDestroyed = " + r.dis.equals("X"));
				if(!r.getDis().equals("X")){
					r.move();
				}
			}
			
			
			if(debug){
				g.print();
			
				Scanner scan = new Scanner(System.in);
				scan.nextLine();
				//scan.close();
			}
			
		}
		
		//Calculate score, it's a zero sum game
		int scoreP1 = (p1.getSlot(0)?1:0) + (p1.getSlot(1)?1:0) + (p1.getSlot(2)?1:0) + (p2.getSlot(0)?0:1) + (p2.getSlot(1)?0:1) + (p2.getSlot(2)?0:1);
		
		
		return new int[] {scoreP1, 6 - scoreP1};
	}
	
	private static boolean gameOver(){
		if(turns > 200){
			return true;
		}
		if(!(p1.getSlot(0) || p1.getSlot(1) || p1.getSlot(2))){ 
			return true;
		}
		if(!(p2.getSlot(0) || p2.getSlot(1) || p2.getSlot(2))){ 
			return true;
		}
		turns++;
		return false;
	}
}
