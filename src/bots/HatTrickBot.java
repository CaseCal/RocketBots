package bots;
import java.util.LinkedList;
import mechanics.*;
/*
 * HatTrickBot always tries to destroy all the enemy slots at once
 * In order to achieve this, each slot needs extrem concentration and coordination
 * It explain why they need some turns to re-synchronized the rockets after one of them dies.
 */
public class HatTrickBot extends Bot
{
    // Default moves are at [0]
    // moves at [1] are used when there's only 2 slots remaining
    // moves  [2-4] are here for when there's only 1 slot remaining
    // it panicks, and can't establish how to fire to do a hat trick.
    // So he will just spamm every ennemy position, one at a time
    String[] rightSlot = {  "770002000020",
                            "0000000001",
                            "0000000000",
                            "0000000001",
                            "0000000011"};
    String[] midSlot   = {  "0000000000",
                            "11000060000",
                            "0000000000",
                            "0000000010",
                            "0000000700"};
    String[] leftSlot  = {  "11000060007",
                            "777702000020",
                            "0000000000",
                            "0000007000",
                            "0000077000"};
    int turnCounter=-1;
    public String name(){return "HatTrickBot";}
    public LinkedList<Integer> fireRocket(Rocket[][] g)
    {
        turnCounter=(turnCounter+1)%3;
        String[][] moves = {rightSlot,midSlot,leftSlot};
        LinkedList<Integer> ll = new LinkedList<Integer>();
        boolean slotL=getSlot(0),slotM=getSlot(1),slotR=getSlot(2);
        int movePoint=0;
        if(slotL&&slotM&&slotR)
        {
            switch(turnCounter)
            {
            case 0: curSlot=0;
                break;
            case 1: curSlot=2;
                break;
            case 2: curSlot=1;
                break;
                default:break;
            }
            movePoint=0;

        }
        else if(!slotM&&slotL&&slotR)
        {
            switch(turnCounter)
            {
            case 0: curSlot=0;
                    movePoint=0;
                break;
            case 1: curSlot=2;
                    movePoint=0;
                break;
            case 2: curSlot=0;
                    movePoint=1;
                break;
                default:break;
            }
        }
        else if(!slotL&&slotM&&slotR)
        {
            switch(turnCounter)
            {
            case 0: curSlot=0;
                    movePoint=0;
                break;
            case 1: curSlot=1;
                    movePoint=1;
                break;
            case 2: curSlot=0;
                    movePoint=1;
                break;
                default:break;
            }
        }
        else if(!slotR&&slotM&&slotL)
        {

            switch(turnCounter)
            {
            case 0: curSlot=2;
                    movePoint=1;
                break;
            case 1: curSlot=1;
                    movePoint=1;
                break;
            case 2: curSlot=1;
                    movePoint=0;
                break;
                default:break;
            }
        }
        else
        {
            if(slotR)curSlot=0;
            if(slotM)curSlot=1;
            if(slotL)curSlot=2;
            movePoint = 2+turnCounter;
        }
        for(int i=0;i<moves[curSlot][movePoint].length();i++)
            ll.push(Integer.parseInt(moves[curSlot][movePoint].charAt(i)+""));
        return ll;
    }
}