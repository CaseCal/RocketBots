package mechanics;


import bots.*;

public class test {

	public static void main(String[] args){
		Bot a = new WallBot();
		Bot b = new WaveBot();
		
		int[] score = Duel.play(a, b, true);
		System.out.println("P1 = " + score[0]);
		
		
	}

}
