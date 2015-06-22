package bots;

import java.util.LinkedList;

import mechanics.*;




public class SimpleBot extends Bot {

	public String name(){
		return "Simple";
	}
	
	public LinkedList<Integer> fireRocket(Rocket[][] g){
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i < 12; i++){
			l.push(0);
		}
		return l;
	}
	
}
