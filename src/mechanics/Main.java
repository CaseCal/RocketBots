package mechanics;
import bots.*;
public class Main {

	public static void main(String[] args){
		Bot[] bots = {new WaveBot(), new SimpleBot()};
		int[] scores = new int[bots.length];
		
		for(int i = 0; i < bots.length - 1; i++){
			for(int j = i + 1; j < bots.length; j++){
				int[] result = Duel.play(bots[i], bots[j], false);
				scores[i] += result[0];
				scores[j] += result[1];
			}
		}
		
		
		for(int i = 0; i < bots.length; i++){
			System.out.println(bots[i].name() + ": " + scores[i]);
		}
	}
	
}
