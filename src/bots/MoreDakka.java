package bots;
import mechanics.*;
import java.util.LinkedList;


public class MoreDakka extends Bot
{
    String[] moves={"70000000001", "0000000000", "0000000000", "0000000000", "1000000007"};
    int[] launcher = new int[]{0, 0, 1, 2, 2};
    int position = -1;

    public String name(){
        return "MoreDakka";
    }

    public LinkedList<Integer> fireRocket(Rocket[][] g)
    {
         LinkedList<Integer> directions = new LinkedList<Integer>();

         if(getSlot(0) || getSlot(1) || getSlot(2))
            do{
                position = (position + 1) % launcher.length;
                curSlot = launcher[position];
            }while(!getSlot(curSlot));

         for(int i=0; i < moves[position].length(); i++)
            directions.push(moves[position].charAt(i)-'0');

         return directions;
    }
}