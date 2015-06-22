package mechanics;

import java.util.Iterator;
import java.util.LinkedList;

public class Grid {

	static final boolean debug = false;
	public Rocket[][] g = new Rocket[9][15];
	Bot p1;
	Bot p2;
	
	public Grid(LinkedList<Rocket> list, Bot p1, Bot p2){
		this.p1 = p1;
		this.p2 = p2;
		
		//int yMid = g.length / 2;
		int xMid = g[0].length /2;
		
		//Fill grid with rockets
		Iterator<Rocket> it = list.iterator();
		if(!it.hasNext()) { 
			if(debug){ System.out.println("Empty Rocket list"); }
			return; }
		Rocket r;
		while(it.hasNext()){
			r = it.next();
			
			//Direct hit?
			if(r.yPos == g.length && r.xPos >= xMid - 1 && r.xPos <= xMid + 1){
				p2.destroySlot(r.xPos - xMid + 1);
			}
			else if(r.yPos == -1 && r.xPos >= xMid - 1 && r.xPos <= xMid + 1){
				p1.destroySlot(r.xPos - xMid + 1);
			}
			//Out of bounds
			if(r.yPos >= g.length || r.xPos >= g[0].length || (r.yPos*r.xPos) < 0){
				it.remove();
				continue;
			}
			
			if(g[r.yPos][r.xPos] == null){
				if(debug){ System.out.println("Added rocket at " + r.xPos + "," + r.yPos);}
				g[r.yPos][r.xPos] = r;
			}
			//Collision
			else{
				g[r.yPos][r.xPos].dis = "X";
				r.dis = "X";
			}
			//Count up turns dead
			if(r.getDis().equals("X")){
				r.turnsDestroyed++;
			}
			//Remove old explosions
			if(r.turnsDestroyed > Rocket.EXPLOSION_LIFE){
				it.remove();
			}
		}
		//System.out.println(" dis at 4,0 = " + g[0][4].dis );
	}
	
	public void print(){
		
		//Print top row
		System.out.print("/");
		for(int i = 0; i < g[0].length/2 - 1; i++){
			System.out.print("---T");
		}
		for(int i = 0; i < 3; i++){
			if(p2.getSlot(i)){ System.out.print("-V-"); }
			else{ System.out.print("-O-"); }
			System.out.print("T");
		}
		for(int i = 0; i < g[0].length/2 - 2; i++){
			System.out.print("---T");
		}
		System.out.println("---\\");
		
		
		
		//Print grid
		for(int k = g.length -1; k >= 0; k-- ){
			Rocket[] row = g[k];
			if(k != g.length - 1) {
				System.out.print("|");
				for(int i = 0; i < g[0].length - 1; i++){
					System.out.print("---+");
				}
				
				System.out.println("---|"); 
			}
			
			System.out.print("|");
			for(int i = 0; i < row.length; i++){
				if(row[i] == null){
					System.out.print("   ");
				}
				else{
					System.out.print(" " + row[i].getDis() + " ");
				}
				System.out.print("|");
			}
			System.out.println();
			
		}
		
		//Print bottom row
		System.out.print("\\");
		for(int i = 0; i < g[0].length/2 - 1; i++){
			System.out.print("---l");
		}
		for(int i = 0; i < 3; i++){
			if(p1.getSlot(i)){ System.out.print("-^-"); }
			else{ System.out.print("-O-"); }
			System.out.print("l");
		}
		for(int i = 0; i < g[0].length/2 - 2; i++){
			System.out.print("---l");
		}
		System.out.println("---/");
		
	}
	
	public Grid(Rocket[][] g, Bot p1, Bot p2){
		this.g = g;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Grid flip(){
		Rocket[][] flip = new Rocket[g.length][g[0].length];
		for(int i = 0; i < g.length - 1; i++){
			for(int j = 0; j < g[g.length - 1 - i].length; j++){
				if(g[g.length - 1 - i][j] != null){
					flip[i][j] = g[g.length - 1 - i][j].dummyFlip();
				}
			}
		}
		
		return new Grid(flip, p2, p1);
	}
	
	
}
