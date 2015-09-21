import kareltherobot.*;
import kareltherobot.Robot;


/**
 * Author: Will Dang
 * 9/15/2015.
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
    /*
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
    */

    //testing
    /*
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
    */

    //testing
    /*
    @SuppressWarnings("InfiniteRecursion")
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
    */

    public int countBeepers() { //assumes empty bag, returns number of beepers on floor, puts beepers back onto floor
        int numberOfBeepers = 0;
        if (!anyBeepersInBeeperBag()){
            while (nextToABeeper()) { //start counting
                pickBeeper();
                numberOfBeepers ++;
            }
            emptyBeeperBag(); // done counting

        }
        else if(!nextToABeeper()) {
            System.err.println("NO BEEPERS HERE");
        }
        else {
            System.err.println("BEEPER BAG NOT EMPTY");
        }
        return numberOfBeepers;
    }
    public void emptyBeeperBag() {
        while (anyBeepersInBeeperBag()) {
            putBeeper();
        }
    }

}



public class test implements Directions  {
    public static void main(String[] args) throws Exception {
        BetterBot b = new BetterBot(9,9,North, 0);
        System.out.println(b.countBeepers());
        b.turnAround();
        b.move();

    }
    static {
        World.reset();
        World.readWorld("C:/Users/jacky/Documents/Karel Shitbot/counting.kwld");
        World.setDelay(1);
        World.setVisible();
    }
}
