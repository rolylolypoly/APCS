import kareltherobot.*;

/**
 * Created by Will Dang on 9/15/2015.
 */

class BetterBot extends Robot
{
    public BetterBot (int st, int av, Direction dir, int beeps) {
        super(st, av, dir, beeps);
    }

    public void turnRight( ) {
        turnLeft();
        turnLeft();
        turnLeft();
    }

// more commands here …

} // end of the blue print
public class test implements Directions {
    public static void main(String[] args) {
        BetterBot b = new BetterBot(1,1,North, 999);
    }
    static {
        
    }
}
