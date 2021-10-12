package Movement;

import java.util.Random;

public class CalculateDamage {

    private static Random randLow;
    private static Random randMed;
    private static Random randHigh;
    private static Random randExt;
    private static int totalDam;
    private static int damVal;


    public static int getDamVal() {
        return damVal;
    }

    public static int getTotalDam() {
        return totalDam;
    }

    public static void setTotalDam(int totalDam) {
        totalDam = totalDam;
    }

    public static void setDamVal(int damVal) {
        damVal = damVal;
    }

    public static void calculateDamage(Player player) {

        randLow = randLow;
        randMed = randMed;
        randHigh = randHigh;
        randExt = randExt;


        int tempDam = player.getHealth();
        int totalDam = tempDam;

        if (player.getPosition() >= 18 && player.getPosition() < 24) {
            int subTotalDam = randLow1() + getDamVal();
            tempDam -= subTotalDam;

            if (player.isHasProtectiveClothing()) {
                tempDam += 1;
            }
          player.setHealth(tempDam);


        } else if (player.getPosition() >= 10 && player.getPosition() <= 15) {
            int subTotalDam = randMed1() + getDamVal();
            tempDam -= subTotalDam;

            if (player.isHasProtectiveClothing()) {
                tempDam += 1;
            }
            player.setHealth(tempDam);

        } else if (player.getPosition() >= 0 && player.getPosition() <= 7) {
            int subTotalDam = randHigh1() + getDamVal();
            tempDam -= subTotalDam;

            if (player.isHasProtectiveClothing()) {
                tempDam += 1;
            }
            player.setHealth(tempDam);

        } else if (player.getPosition() >= 16 && player.getPosition() <= 17) {
            int subTotalDam = randExt1() + getDamVal();
            tempDam -= subTotalDam;

            if (player.isHasProtectiveClothing()) {
                tempDam += 1;
            }
            player.setHealth(tempDam);
        }

    }

    //random number either 1 or 2 add to
    public static int randLow1() {
        randLow = new Random();
        return randLow.nextInt(2 + 1);
    }


    //random number between 1 and 3
    public static int randMed1() {
        randMed = new Random();
        return randMed.nextInt((2 + 1) + 1);
    }

    //random number between 1 and 4
    public static int randHigh1() {
        randHigh = new Random();
        return randHigh.nextInt((3 + 1) + 1);
    }

    //random number between 1 and 20
    public static int randExt1() {
        randExt = new Random();
        return randExt.nextInt((19 + 1) + 1);

    }


    public void setRandLow(Random randLow) {
        randLow = randLow;
    }

    public Random getRandLow() {
        return randLow;
    }

    public void setRandMed(Random randMed) {
        randMed = randMed;
    }

    public Random getRandMed() {
        return randMed;
    }

    public void setRandHigh(Random randHigh) {
        randHigh = randHigh;
    }

    public Random getRandHigh() {
        return randHigh;
    }

    public void setRandExt(Random randExt) {
        randExt = randExt;
    }

    public Random getRandExt() {
        return randExt;
    }





}

