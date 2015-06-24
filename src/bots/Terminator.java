package bots;

import java.util.LinkedList;
import mechanics.Bot;
import mechanics.Rocket;

public class Terminator extends Bot {

    int n = 0;
    String[] moves = {"000", "0111107777", "00", "0077700111", "00", "0777701111"};

    public String name() {
        return "Terminator";
    }

    @Override
    public LinkedList<Integer> fireRocket(Rocket[][] g) {
        curSlot = (n+1) % 3;

        LinkedList<Integer> commands = loadCommands(moves[n % moves.length]);
        n++;

        return commands;
    }

    protected LinkedList<Integer> loadCommands(String commands) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < commands.length(); i++) {
            linkedList.push(commands.charAt(i) - 48);
        }

        return linkedList;
    }

}