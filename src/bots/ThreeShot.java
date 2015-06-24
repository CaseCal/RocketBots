package bots;import java.util.*;import mechanics.*;

public class ThreeShot extends Bot{
    public String name(){state = 0;return "3 Shot";}
    private int state;

    public LinkedList<Integer> fireRocket(Rocket[][] g){
        LinkedList<Integer> command = new LinkedList<Integer>();
        if(state < 2){
           state++;
           return fireLeft();
        }
        if(state < 4){
           state++;
           return fireCenter();
        }
        state=(state+1)%6;
        return fireRight();
    }
    LinkedList<Integer> fireCenter(){
        LinkedList<Integer> command = new LinkedList<Integer>();
        curSlot = 1;
        while(command.size()<90){
            command.push(1);
            command.push(7);
            command.push(6);
            command.push(1);
        }
        return command;
    }
    LinkedList<Integer> fireRight(){
        LinkedList<Integer> command = new LinkedList<Integer>();
        curSlot = 2;
        command.push(1);
        for(int i=0;i<8;i++){
            command.push(0);
        }
        command.push(7);
        return command;
    }
    LinkedList<Integer> fireLeft(){
        LinkedList<Integer> command = new LinkedList<Integer>();
        curSlot = 0;
        command.push(7);
        for(int i=0;i<8;i++){
            command.push(6);
            command.push(1);
        }
        command.push(1);
        return command;
    }
}