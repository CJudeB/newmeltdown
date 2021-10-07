package Movement;

import java.util.ArrayList;
import java.util.Random;


public class CalculateDamage extends Tile{
    private int randLow;
    private int randMed;
    private int randHigh;
    private int randExt;


    public int totalDamage(Player player, ArrayList<Tile> tileRef, int randLow, int randMed, int randHigh, int randExt) {
        this.randLow = randLow;
        this.randMed = randMed;
        this.randHigh = randHigh;
        this.randExt = randExt;

        //finds the players position and the damVal on that tile
        //and adds a randomly generated number from one of four ranges (Low, Med, High, Ext)
        //returns totalDam which is passed to updateHealth.

        int pPos = player.getPosition();
        int damVal = tileRef.get(player.getPosition()).getDamVal();
        int totalDam = 0;

        if (pPos >= 18 && pPos < 24) {
            int r = randLow + damVal;
            return totalDam = player.getHealth() - r;
        } else if (pPos >= 10 && pPos <= 15) {
            int r = randMed + damVal;
            return totalDam = player.getHealth() - r;
        } else if (pPos >= 0 && pPos <= 7) {
            int r = randHigh + damVal;
            return totalDam = player.getHealth() - r;
        } else if (pPos >= 16 && pPos <= 17) {
            int r = randExt + damVal;
            return totalDam = player.getHealth() - r;
        }

        return totalDam;
    }

    public static int updateHealth(int totalDam, Player player) {
        int h = player.getHealth();
        int health = 0;
        if (player.isAlive()) {
            health = h - totalDam;
        }
        System.out.println("Game over you died");
        return health;
    }



   /* public RandomDamage(int randLow, int randMed, int randHigh, int randExt) {
        this.randLow = randLow;
        this.randMed = randMed;
        this.randHigh = randHigh;
        this.randExt = randExt;
    }*/

    //random number either 1 or 2 add to
    private static int randNumLow() {
        Random randLow = new Random();
        return randLow.nextInt(2) + 1;
    }

    //random number between 1 and 3
    private static int randNumMed() {
        Random randMed = new Random();
        return randMed.nextInt(2 + 1) + 1;
    }

    //random number between 1 and 4
    private static int randNumHigh() {
        Random randHigh = new Random();
        return randHigh.nextInt(3 + 1) + 1;
    }

    //random number between 1 and 20
    private static int randNumExt() {
        Random randExt = new Random();
        return randExt.nextInt(19 + 1) + 1;
    }


    public void setRandNumLow(int randLow) {
        this.randLow = randLow;
    }

    public int getRandNumLow() {
        return randLow;
    }

    public void setRandNumMed(int randMed) {
        this.randMed = randMed;
    }

    public int getRandNumMed() {
        return randMed;
    }

    public void setRandNumHigh(int randHigh) {
        this.randHigh = randHigh;
    }

    public int getRandNumHigh() {
        return randHigh;
    }

    public void setRandNumExt(int randExt) {
        this.randExt = randExt;
    }

    public int getRandNumExt() {
        return randExt;
    }


}

