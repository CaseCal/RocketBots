package bots;

import java.util.LinkedList;
import mechanics.*;



public class SideShooter extends Bot {

    int[] launcher = new int[]{1, 3, 2, 2, 2};
    String[] right = {"1100000077", "100000007"};
    String[] left  = {"7700000011", "700000001"}; 
    int position = -1;
    int turns = 0;

    public String name(){
        return "SideShooter";
    }

    public LinkedList<Integer> fireRocket(Rocket[][] g){
      LinkedList<Integer> directions = new LinkedList<Integer>();

      if(getSlot(0) || getSlot(1) || getSlot(2)){      
          do{
              position = (position + 1) % 5;
              curSlot = launcher[position] - 1;
          }while(!getSlot(curSlot));
      }
      if(position == 0)
      {
          String shoot = left[((int) (Math.random() * left.length))];
          for(int i=0; i < shoot.length(); i++)
              directions.push(shoot.charAt(i)-'0');
      }else if(position == 1)
      {
          String shoot = right[((int) (Math.random() * right.length))];
          for(int i=0; i < shoot.length(); i++)
              directions.push(shoot.charAt(i)-'0');
      }else
      {
          if(turns < 30)
          {
            if(position == 2 )
                directions.push(0);
            else if(position == 3)
                directions.push(1);
            else if(position == 4)
                directions.push(7);
          }else
              for(int i=0; i < 10; i++)
                  directions.push(0); 
      }
      turns ++;
      return directions;
    }

}