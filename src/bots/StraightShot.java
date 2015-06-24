package bots;import java.util.*;import mechanics.*;

public class StraightShot extends Bot{
    public String name(){return "StraightShot";}

    public LinkedList<Integer> fireRocket(Rocket[][] g){
        LinkedList<Integer> command = new LinkedList<Integer>();
    	curSlot = (curSlot+1)%3;
        for(int i=0;i<100;i++)
            command.push(0);
        return command;
    }
}