package bots;

import java.util.LinkedList;
import mechanics.*;

public class Defender extends Bot {
    int turn = 0;

    @Override
    public String name() {
        return "Defender";
    }

    @Override
    public LinkedList<Integer> fireRocket(Rocket[][] grid) {
        LinkedList<Integer> command = new LinkedList<Integer>();
        for (int i = 0; i < 3; i++) {
            if ((grid[0][6+i] == null || grid[0][6+i].getDis().equals("v")) && (grid[1][6+i] == null || grid[1][6+i].getDis().equals("v")) && getSlot(i)) {
                curSlot = i;
                command.push(0);
                for (int j = 0; j < 50; j++) {
                    command.push(0);
                    command.push(4);
                }
                break;
            }
        }

        if (command.isEmpty()) {
            if ((grid[0][9] == null || grid[0][9].getDis().equals("v")) && (grid[0][10] == null || grid[0][10].getDis().equals("v")) && (grid[1][10] == null || grid[1][10].getDis().equals("v")) && getSlot(2)) {
                curSlot = 2;
                command.push(1);
                command.push(1);
                command.push(4);
                for (int i = 0; i < 50; i++) {
                    command.push(6);
                    command.push(2);
                }
            } else if ((grid[0][5] == null || grid[0][5].getDis().equals("v")) && (grid[0][4] == null || grid[0][4].getDis().equals("v")) && (grid[1][4] == null || grid[1][4].getDis().equals("v")) && getSlot(0)) {
                curSlot = 0;
                command.push(7);
                command.push(7);
                command.push(4);
                for (int i = 0; i < 50; i++) {
                    command.push(2);
                    command.push(6);
                }
            }

        }

        if (command.isEmpty()) {
            if (turn % 2 == 0 && getSlot(0)){
                curSlot = 0;
                command.push(7);
                command.push(7);
                for (int i = 0; i < 7; i++) {
                    command.push(0);
                }
                command.push(2);
                for (int i = 0; i < 2; i++) {
                    if (Math.random() < 0.2) command.push(2);
                }
                command.push(1);
            } else {
                curSlot = 2;
                command.push(1);
                command.push(1);
                for (int i = 0; i < 7; i++) {
                    command.push(0);
                }
                command.push(6);
                for (int i = 0; i < 2; i++) {
                    if (Math.random() < 0.5) command.push(6);
                }
                command.push(7);
            }
        }

        turn++;
        return command;
    }
}