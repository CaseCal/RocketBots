package bots;

import mechanics.*;
import java.util.LinkedList;

public class Tortoise extends Bot
{
    int turnCounter=-1;
    boolean attacked=false;
    int[] moves={7,0,0,0,1};
    public String name(){return "Tortoise";}
    public LinkedList<Integer> fireRocket(Rocket[][] g)
    {
         LinkedList<Integer> rocket = new LinkedList<Integer>();
         turnCounter++;
         if(!attacked)
         {
             curSlot=turnCounter;
             for(int i=0;i<11;i++)
                 rocket.push(0);
             if(turnCounter==2)
                 attacked=true;
             return rocket;
         }
         turnCounter%=5;
         switch(turnCounter)
         {
         case 0:
         case 1:curSlot=0;break;
         case 2:curSlot=1;break;
         case 3:
         case 4:curSlot=2;break;
            default:break;
         }
         rocket.push(moves[turnCounter]);
         return rocket;
    }
}