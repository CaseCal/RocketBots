package bots;import java.util.*;import mechanics.*;

public class Zigzagoon extends Bot{
    String[] evenMoves = {"7000000001","0170710170","1000000007"};
    String[] oddMoves = {"0","00","0"};
    boolean even = true;
    public String name(){return "Zigzagoon";}

    public LinkedList<Integer> fireRocket(Rocket[][] g){
        curSlot = (curSlot+1)%3;
        if(curSlot<1)even=!even;
        String[] moves = even?evenMoves:oddMoves;
        LinkedList<Integer> command = new LinkedList<Integer>();
        for(int i=0;i<moves[curSlot].length();i++)
            command.push(moves[curSlot].charAt(i)-'0');
        return command;
    }
}