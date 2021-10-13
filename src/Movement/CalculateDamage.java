package Movement;

import java.util.Random;

public class CalculateDamage {


    private static Random randMed;
    private static Random randHigh;
    private static Random randExt;
    private static int totalDam;
    private static int damVal;



    public static void setDamVal(int damVal) {
        CalculateDamage.damVal = damVal;
    }

    private static Random randLow;

    public static Random getRandMed() {
        return randMed;
    }

    public static void setRandMed(Random randMed) {
        CalculateDamage.randMed = randMed;
    }

    public static Random getRandHigh() {
        return randHigh;
    }

    public static void setRandHigh(Random randHigh) {
        CalculateDamage.randHigh = randHigh;
    }

    public static Random getRandExt() {
        return randExt;
    }

    public static void setRandExt(Random randExt) {
        CalculateDamage.randExt = randExt;
    }

    public static int getDamVal() {
        return damVal;
    }

    public static int getTotalDam() {
        return totalDam;
    }

    public static void setTotalDam(int totalDam) {
        totalDam = totalDam;
    }




    public static void calculateDamage(Player player) {

        int damValLow = 3;
        int damValMed = 4;
        int damValHigh = 6;
        int damValExt = 35;
        int tempDam = player.getHealth();
        int totalDam = tempDam;

        //if (player.getPosition() >= 18 && player.getPosition() < 24)
        if (player.isAlive()) {

            if (player.getPosition() >= 18 && player.getPosition() < 24) {
                // int subTotalDam = randLowMethod() + getDamVal();
                int subTotalDam = randLowMethod() + damValLow;
                tempDam -= subTotalDam;

                if (player.isHasProtectiveClothing()) {
                    tempDam += 1;
                }
                player.setHealth(tempDam);


            } else if (player.getPosition() >= 10 && player.getPosition() <= 15) {
                int subTotalDam = randMedMethod() + damValMed;
                tempDam -= subTotalDam;

                if (player.isHasProtectiveClothing()) {
                    tempDam += 1;
                }
                player.setHealth(tempDam);

            } else if (player.getPosition() >= 0 && player.getPosition() <= 7) {
                int subTotalDam = randHighMethod() + damValHigh;
                tempDam -= subTotalDam;

                if (player.isHasProtectiveClothing()) {
                    tempDam += 1;
                }
                player.setHealth(tempDam);

            } else if (player.getPosition() >= 16 && player.getPosition() <= 17) {
                int subTotalDam = randExtMethod() + damValExt;
                tempDam -= subTotalDam;

                if (player.isHasProtectiveClothing()) {
                    tempDam += 1;
                }
                player.setHealth(tempDam);
            }
            System.out.println("You died. Game over.");
        }
    }


    //random number either 1 or 2 add to
    public static int randLowMethod() {
        randLow = new Random();
        return randLow.nextInt(2 + 1);
    }


    //random number between 1 and 3
    public static int randMedMethod() {
        randMed = new Random();
        return randMed.nextInt((2 + 1) + 1);
    }

    //random number between 1 and 4
    public static int randHighMethod() {
        randHigh = new Random();
        return randHigh.nextInt((3 + 1) + 1);
    }

    //random number between 1 and 20
    public static int randExtMethod() {
        randExt = new Random();
        return randExt.nextInt((19 + 1) + 1);

    }


}

