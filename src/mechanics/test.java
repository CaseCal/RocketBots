package mechanics;


import bots.*;

public class test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Bot a = new Terminator();
		Bot b = new Defender();
		
		int[] score = Duel.play(a, b, true);
		System.out.println("P1 = " + score[0]);
		
		
	}

}
