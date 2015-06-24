package bots;
import mechanics.*;
import java.util.LinkedList;

public class Sniper extends Bot {

    int[] launcher = new int[]{1, 3, 1, 2, 3};
    String[] moves = {"7", "1", "0000000000", "0000000000", "0000000000"}; 
    int position = -1, move = 0;

    public String name(){
        return "Sniper";
    }

    public LinkedList<Integer> fireRocket(Rocket[][] g){
        LinkedList<Integer> directions = new LinkedList<Integer>();
        if(getSlot(0) || getSlot(1) || getSlot(2))
        do{
            position = (position + 1) % launcher.length;
            curSlot = launcher[position] - 1;
        }while(!getSlot(curSlot));

        for(int i=0; i < moves[move].length(); i++)
            directions.push(moves[move].charAt(i)-'0');

        move = (move + 1) % moves.length;

        return directions;
    }

}