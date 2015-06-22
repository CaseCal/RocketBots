package mechanics;
import java.util.LinkedList;

public class Rocket {

	static final int EXPLOSION_LIFE = 5;
	static final int LIFETIME = 50;
	
	private LinkedList<Integer> path;
	int xPos;
	int yPos;
	String dis;
	int turnsFired = 0;
	int turnsDestroyed = 0;
	
	public Rocket(LinkedList<Integer> moves, String owner, int startX, int startY) {
		path = moves;
		dis = owner;
		xPos = startX;
		yPos = startY;
	}
	
	public Rocket(String d){
		dis = d;
	}
	
	protected void move(){
		
		//Explode at the end of the path or when out of fuel
		if(path.peekLast() == null || turnsFired > LIFETIME){
			dis = "X";
			return;
		}
		turnsFired++;
		int nextMove = path.pollLast().intValue();
		switch(nextMove){
			case 0:
				yPos++;
				break;
			case 1:
				yPos++;
				xPos++;
				break;
			case 2:
				xPos++;
				break;
			case 3:
				yPos--;
				xPos++;
				break;
			case 4:
				yPos--;
				break;
			case 5:
				yPos--;
				xPos--;
				break;
			case 6:
				xPos--;
				break;
			case 7:
				xPos--;
				yPos++;
				break;
			default:
				dis = "X";
				break;				
		}
		
	}
	
	public void flip(){
		for(int i = 0; i < path.size(); i++){
			path.set(i, (path.get(i) + 4)%8);
		}
	}
	
	public Rocket dummyFlip(){
		String d;
		if(getDis().equals("^")){
			d = "v";
		}
		else if(getDis().equals("v")){
			d = "^";
		}
		else{
			d = "X";
		}
		
		return new Rocket(d);
		
		
	}


	public String getDis() {
		return dis;
	}



}
