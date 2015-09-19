import kareltherobot.*;
import kareltherobot.Robot;

import java.awt.*;

/**
 * Created by Will Dang on 9/15/2015.
 */

class BetterBot extends Robot implements Directions {
    public BetterBot(int st, int av, Direction dir, int beeps) {
        super(st, av, dir, beeps);
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    //this gets ugly
    public void returnToOrigin() { //assumes no obstacles
        while (!facingSouth()) {
            turnLeft();
        }
        if (facingSouth()) {
            while (frontIsClear()) {
                move();
            }
            if (!frontIsClear()) {
                turnRight();
                while (frontIsClear()) {
                    move();
                }
            }
        }
    }

    public void roombaLeft() {
        while(frontIsClear()) {
            move();
        }
        while (!frontIsClear()) {
            turnLeft();
        }
        roombaRight();
    }
    public void roombaRight() {
        while(frontIsClear()) {
            move();
        }
        while (!frontIsClear()) {
            turnRight();
        }
        roombaLeft();
    }
    public void SimplePathing() {
        if (frontIsClear()) {
            move();
            turnLeft();
            SimplePathing();
        }
        else {
            while (!frontIsClear()) {
                turnRight();
            }
            SimplePathing();
        }
    }
    public int countBeepers() {
        int numberOfBeepers = 0;
        if (!anyBeepersInBeeperBag()){
            while (nextToABeeper()) {
                pickBeeper();
                numberOfBeepers ++;
            }
            return numberOfBeepers;
            while (anyBeepersInBeeperBag()) {
                putBeeper();
            }
        }
        else {
            System.err.print("BEEPER BAG NOT EMPTY");
        }

    }

}



public class test implements Directions  {
    public static void main(String[] args) throws Exception {
        BetterBot b = new BetterBot(9,9,North, 999);
        b.SimplePathing();


    }
    static {
        World.reset();
        World.readWorld("C:/Users/jacky/Documents/Karel Shitbot/openproblembox.kwld");
        World.setDelay(1);
        World.setVisible();
    }
}
