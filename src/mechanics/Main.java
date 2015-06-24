package mechanics;
import bots.*;
public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Bot[] bots = { new SimpleBot(), new Zigzagoon(), new WallE(), new Tortoise(), new ThreeShot(),
					   new HatTrickBot(), new Sniper(), new SideShooter(), new Terminator(), new StraightShot(),
					   new Defender(), new MoreDakka()};
		int[] scores = new int[bots.length];
		
		for(int game = 0; game < 100; game++){
			for(int i = 0; i < bots.length - 1; i++){
				for(int j = i + 1; j < bots.length; j++){
					Bot a = bots[i].getClass().newInstance();
					Bot b = bots[j].getClass().newInstance();
					int[] result = Duel.play(a, b, false);
					//System.out.println(bots[i].name() + " = " + result[0] + "\t " + bots[j].name() + " = " + result[1]);
					scores[i] += result[0];
					scores[j] += result[1];
				}
			}
		}
		
		for(int i = 0; i < bots.length; i++){
			System.out.println(bots[i].name() + ": " + scores[i]);
		}
	}
	
}
