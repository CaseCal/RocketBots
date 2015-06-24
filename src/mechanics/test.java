package mechanics;


import bots.*;

public class test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Bot a = new WallE();
		Bot b = new ThreeShot();
		
		int[] score = Duel.play(a, b, true);
		System.out.println("P1 = " + score[0]);
		
		
	}

}
