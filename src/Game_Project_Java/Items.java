package Game_Project_Java;

import java.util.Scanner;

import static Game_Project_Java.CalculateDamage.calculateDamage;

public class Items {

    static boolean cabinetUsed = false;
    static boolean firstInteraction = true;
    /**
     * Use wrench boolean. The interaction method for using the wrench.
     * Includes blocks for the player not having the wrench and trying to use the pipeline
     *
     * @param item         the item that the user input to interact with
     * @param tile         the tile the player is on
     * @param player       the player instance from game
     * @return the boolean
     */
    public static boolean useWrench (String item, Tile tile, Player player) {
        Validation v = new Validation();
        //If not holding wrench
        if (!v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench")) {
            //If player on 2C
            if(tile.gettIntractable().equalsIgnoreCase("pipeline")){
                System.out.println("If you had a tool you might be able to fix the pipe");
            }else
                System.out.println("I'm not holding an item like that");
            return false;
        }
        //If wrench is in inventory and on 2C
        else if(v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench") && tile.gettIntractable().equalsIgnoreCase("pipeline")) {
            System.out.println("You use the wrench to fix the pipe");
            calculateDamage(player, tile);
            return true;
        }
        //If wrench is in inventory and not on 2C
        else if (v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench") && !tile.gettIntractable().equalsIgnoreCase("pipeline")){
            System.out.println("I'm not sure what I would use that for here");
            return false;
        } else
            return false;
    }

    public static void useCoreRegulator(String tIntractable, Tile tile, Player player) {

        if (tIntractable.equalsIgnoreCase(tile.gettIntractable())) {

      //    (tIntractable.equalsIgnoreCase(tile.gettIntractable())) {
            System.out.println("""
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4E
                    
                    You are relieved to discover the instruments are familiar to you.
                    
                    What you can't understand, or rather, what you cannot believe, is what the readings are showing.
                    They must have been damaged in the accident, or whatever caused the roof to cave in.
                    Yes, there is no other explanation - for the readings to be accurate, the reactor would have be on
                    the brink of a meltdown, and that’s impossible.
                    
                    If they were genuine though, which they are not - but if they were, a meltdown must be stopped.
                    
                    There is an exit west, where you entered, or south.
                    
                                       
                    move n, s, e, w       	|     use (item)      	|       pick-up (item)	    |	    help help
                    inventory i           	|     map m           	|       quit q		        | 	    exit exit
                    drop (item)
                    
                    
                    """);


        }
    }


    /**
     * Use the fallen over cabinets in tile 5B
     * Asks the player for 3 numbers to unlock the lock
     * If it's wrong send the player back to the tile and end the turn
     *
     *
     * @param item   the item that the user inputted to use
     * @param tile   the tile that the player is currently on
     * @param player the player instance
     */
    public static void useCabinets (String item, Tile tile, Player player){

        if(!cabinetUsed) {
            if (item.equalsIgnoreCase(tile.gettIntractable())) {
                if (firstInteraction) {
                    System.out.println("You shift the cabinet onto it's back.");
                    firstInteraction = false;
                }
                System.out.println("You place your hand on the locks dial and remembering the markings from before\n(4b1c-5c, (2e4b%3d)+2d, 3d+=3d) you enter -");
                Scanner code = new Scanner(System.in);
                int[] combination = new int[3];
                for (int i = 0; i < combination.length; ) {
                    if (i == 0) {
                        System.out.println("The first number:");
                    } else if (i == 1) {
                        System.out.println("The second number:");
                    } else if (i == 2) {
                        System.out.println("The third number:");
                    }
                    System.out.print(">");
                    try {

                        int temp = code.nextInt();
                        code.nextLine();
                        if (temp >= 0 && temp <= 35) {
                            combination[i] = temp;
                            i++;
                        } else {
                            System.out.println("The lock only takes numbers from 0-35");
                        }
                    } catch (Exception e) {
                        System.out.println("The lock only takes numbers from 0-35");
                        code.nextLine();
                    }
                }
                System.out.println("You turn the dial clockwise to " + combination[0] + ".\nThen counterclockwise to " + combination[1] + ".\nFinally clockwise once more to " + combination[2]);
                if ((combination[0] == 26) && (combination[1] == 17) && (combination[2] == 28)) {
                    System.out.println("""
                                    
                            The numbers match and the lock opens.
                            You find the Hazmat suit and dosimeter inside, a small key and a thick pile of rouble bills.
                                    
                            Putting the heavy suit on is an ordeal though, and you half-collapse from the effort,
                            losing your hold on the key and roubles, which scuttle away, back from where you came.
                                   
                            """);
                    player.addItems("hazmat");
                    tile.settItems("roubles");
                    tile.settItems("key");
                    player.setHasProtectiveClothing(true);
                    cabinetUsed = true;
                } else {
                    System.out.println("The lock doesn't budge perhaps I got it wrong.\nYou step back from the cabinet to think about it.");
                }
                calculateDamage(player, tile);
            }
        }else{
            System.out.println("There is nothing else to use in the cabinet");
        }

    }
}







