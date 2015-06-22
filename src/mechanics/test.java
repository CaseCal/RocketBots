package mechanics;


import bots.*;

public class test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Bot b = (new WaveBot()).getClass().newInstance();
		Bot a = (new Zigzagoon()).getClass().newInstance();
		
		int[] score = Duel.play(a, b, true);
		System.out.println("P1 = " + score[0]);
		
		
	}

}
