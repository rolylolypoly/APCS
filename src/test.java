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
    public void checkPick() {
        if (nextToABeeper()) {
            pickBeeper();
            checkPick();
        }
        else {
            System.out.println("No beeper here.");
        }
    }
    public void leekspinL() { //assumes hugging south wall
        turnLeft();
        avoid();
        turnRight();
        avoid();
        turnRight();
        avoid();
        turnLeft();
    }
    public void avoid() {
        if (frontIsClear()) {
            move();
            checkPick();
        }
        else {
            leekspinL();
        }
    }
    /*
    public void pathfinding() {
        int n = 0;
        while(n<=9) { //number of iterations
            avoid();
            n++;
        }
    }
    */
    public void moveR() {
        turnRight();
        move();
    }
    public void moveL() {
        turnLeft();
        move();
    }
    public void findNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void pastafarianism() {
        if (facingNorth()) {
            switch (countBeepers() % 2) {
                case 0: moveR();
                    break;
                case 1: moveL();
                    break;
            }
        }
        else {
            findNorth();
        }

    }
    public boolean wallOnRight() {
        turnRight();
        if (frontIsClear()) {
            turnLeft();
            return false;
        }
        else {
            turnLeft();
            return true;
        }
    }
    public boolean wallOnLeft() {
        turnLeft();
        if (frontIsClear()) {
            turnRight();
            return false;
        }
        else {
            turnRight();
            return true;
        }
    }
    public boolean beeperOnRight() {
        turnRight();
        if (frontIsClear()) {
            move();
            if (nextToABeeper()) {
                turnAround();
                move();
                turnRight();
                return true;
            }
            else {
                turnAround();
                move();
                turnRight();
                return false;
            }
        }
        else {
            System.err.println("PATH BLOCKED BY WALL");
            return false;
        }
    }
    public boolean beeperOnLeft() {
        turnLeft();
        if (frontIsClear()) {
            move();
            if (nextToABeeper()) {
                turnAround();
                move();
                turnLeft();
                return true;
            }
            else {
                turnAround();
                move();
                turnLeft();
                return false;
            }
        }
        else {
            System.err.println("PATH BLOCKED BY WALL");
            return false;
        }
    }
    public void moveOut() {
        while (!facingSouth()) {
            turnLeft();
        }
        move();
        turnLeft();
    }
    public boolean isRoom() {
        move();
        turnLeft();
        int n;
        for (n = 0; n <= 2; n++) {
            if (frontIsClear()) {
                turnRight();
            }
            else {
                moveOut();
                return false;
            }
        }
        moveOut();
        return true;
    }
    public void checkRoom() {
        move();
        turnLeft();
        if (isRoom()) {
            turnLeft();
            move();
            putBeeper();
            turnAround();
            move();
            turnLeft();
        }
        else {
            System.out.println("SHUT UP ANDREW!");
        }

    }
    public void roomBeeper() {
        int n;
        for (n=0; n<= 8; n++) {
            checkRoom();
        }
    }
}



public class test implements Directions  {
    public static void main(String[] args) throws Exception {
        BetterBot b = new BetterBot(8,4,North, 0);


    }
    static {
        World.reset();
        World.readWorld("C:/Users/jacky/Downloads/blank.kwld");
        World.setDelay(1);
        World.setVisible();
    }
}
