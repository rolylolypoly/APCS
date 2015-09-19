import kareltherobot.*;

/**
 * Created by Will Dang on 9/15/2015.
 */

class BetterBot extends Robot implements Directions
{
    public BetterBot (int st, int av, Direction dir, int beeps) {
        super(st, av, dir, beeps);
    }

    public void turnRight( ) {
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
            if (!frontIsClear()){
                turnRight();
                while (frontIsClear()) {
                    move();
                }
            }
        }
    }


// more commands here …

} // end of the blue print
public class test implements Directions {
    public static void main(String[] args) throws Exception{
        BetterBot b = new BetterBot(9,9,North, 999);
        b.returnToOrigin();

    }
    static {
        World.reset();
        World.readWorld("C:/Users/jacky/Documents/Karel Shitbot/blank.kwld");
        World.setDelay(0);
    }
}
