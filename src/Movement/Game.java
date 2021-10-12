package Movement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Movement.CalculateDamage.calculateDamage;
import static Movement.Cart.*;
import static Movement.Event.currentEvent;
import static Movement.Event.getPrologue;
import static Movement.Items.useHazmat;
import static Movement.Items.useWrench;


public class Game {

    private static int health;
    private Map mapPane;
    private ArrayList<Tile> tileRef;
    private Player player;
    private boolean pipelineFixed = false, quit = false, exitFacility = false;

    public Game() throws IOException {
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(new Tile("\n\n0.1A", "Stairs", null, "", false, true, true, false, 8));
        this.tileRef.add(new Tile("1.1B", "", null, "", false, true, false, true, 8));
        this.tileRef.add(new Tile("2.1C", "", null, "", false, false, true, true, 10));
        this.tileRef.add(new Tile("3.1D(Unreachable)", "", null, "", false, false, false, false, 0));
        this.tileRef.add(new Tile("4.1E(Unreachable)", "", null, "", false, false, false, false, 0));
        //row 2
        this.tileRef.add(new Tile("5.2A", "", null, "", true, false, true, false, 6));
        this.tileRef.add(new Tile("6.2B(Unreachable)", "", null, "", false, false, false, false, 0));
        this.tileRef.add(new Tile("7.2C", "pipeline", null, "", true, false, false, false, 10));
        this.tileRef.add(new Tile("8.2D(Unreachable)", "", null, "", true, false, false, false, 0));
        this.tileRef.add(new Tile("9.2E(Unreachable)", "", null, "", false, false, false, false, 0));
        //row 3
        this.tileRef.add(new Tile("10.3A(Exit via West)", "", null, "cart", true, false, true, false, 6));
        this.tileRef.add(new Tile("11.3B(Unreachable)", "", null, "", false, false, false, false, 0));
        this.tileRef.add(new Tile("12.3C(Unreachable)", "", null, "", false, false, false, false, 0));
        this.tileRef.add(new Tile("13.3D(Unreachable)", "", null, "", false, false, false, false, 0));
        this.tileRef.add(new Tile("14.3E(Unreachable)", "", null, "", false, false, false, false, 0));
        //row 4
        this.tileRef.add(new Tile("15.4A", "", null, "", true, true, true, false, 5));
        this.tileRef.add(new Tile("16.4B", "", null, "", false, true, false, true, 35));
        this.tileRef.add(new Tile("17.4C(West of Start)", "", null, "", false, true, false, true, 35));
        this.tileRef.add(new Tile("18.4D(Start)", "", mapPane, "", false, true, false, true, 3));
        this.tileRef.add(new Tile("19.4E(East of Start)", "instruments", null, "", false, false, true, true, 3));
        //row 5
        this.tileRef.add(new Tile("\n\n20.5A", "", null, "", true, true, false, false, 3));
        this.tileRef.add(new Tile("21.5B", "", null, "", false, true, false, true, 3));
        this.tileRef.add(new Tile("22.5C: \nYou notice a small walk-in closet with a cabinet, table and small sofa.\nA break room for staff.\nThe ticking seems to be coming from in there, maybe I should investigate the furniture inside.", "cabinet", null, "", false, true, false, true, 3));
        this.tileRef.add(new Tile("23.5D", "", null, "", false, true, false, true, 3));
        this.tileRef.add(new Tile("24.5E", "", null, "", true, false, false, true, 3));

        //Add items to tile 4D
        this.tileRef.get(19).settItems("wrench");
        //Add items to tile 5A
        this.tileRef.get(20).settItems("fuel");
        //Add items to tile 5C
        this.tileRef.get(22).settItems("cart-key");
        this.tileRef.get(22).settItems("Hazmat");

        //Test items
        this.tileRef.get(10).settItems("cart-key");
        this.tileRef.get(10).settItems("fuel");
        //Create player
        player = new Player("Tester");
        mapPane = new Map();

    }


    public void setPipelineFixed(boolean pipelineFixed) {
        this.pipelineFixed = pipelineFixed;
    }

    public void setMapPane(Tile tile, Player player) {
    }

    public void moveTile(String dir, int newTile) {


        //Removing cart from tile if needed
        if(player.isInCart() && !(player.getPosition() == 2)){
            tileRef.get(player.getPosition()).settCart("");
        }
        //Move the player from one space to the next if possible otherwise tell them they can't
        if (dir.equals("n") && this.tileRef.get(this.player.getPosition()).gettN()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("s") && this.tileRef.get(this.player.getPosition()).gettS()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("e") && this.tileRef.get(this.player.getPosition()).gettE()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("w") && this.tileRef.get(this.player.getPosition()).gettW()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("badInput")) {
            System.out.println("That's not a direction I can move");
        } else {
            System.out.println("You cannot go that way");
        }
        //Setting cart into tile if needed
        if(player.isInCart() && !(player.getPosition() == 7)){
            tileRef.get(player.getPosition()).settCart("cart");
        }
    }

    //Method to drop items from player inventory and add to the tile inventory
    public String[] dropItem(String item, String pInven[]) {
        //If validate returns badInput print
        if (item.equals("badInput")) {
            System.out.println("You aren't holding a item like that");
            return pInven;
}
        for (int i = 0; i < pInven.length; i++) {
        if (pInven[i].equals(item)) {
        pInven[i] = null;
        System.out.println("You dropped the " + item);
        this.tileRef.get(this.player.getPosition()).settItems(item);
        return pInven;
        }
        }
        return pInven;
        }

//Method to pickup items from tile inventory and add to the player inventory
public String[] pickItem(String item, String pInven[]) {
    String itemToDrop;
    Scanner input = new Scanner(System.in);
    Validation v = new Validation();
    boolean itemDropped = true;
    if (item.equals("badInput")) {
        System.out.println("There doesn't seem to be an item like that here");
        return pInven;
    }
    for (int i = 0; i < pInven.length; i++) {
        if (pInven[i] == null) {
            pInven[i] = item;
            this.tileRef.get(this.player.getPosition()).removeItem(item);
            System.out.println("You picked up the " + item);
            return pInven;
        } else if (i == pInven.length - 1) {
            System.out.println("You’re feeling very weak – there’s no way you can carry more. 'Why am I carrying all this stuff', you think to yourself.");
            System.out.println("What should I drop for the item?");
            player.printInventory();
            do {
                System.out.print(">");
                itemToDrop = input.nextLine();
                for (int a = 0; a < pInven.length; a++) {
                    if (pInven[a].equalsIgnoreCase(itemToDrop)) {
                        pInven[a] = item;
                        this.tileRef.get(this.player.getPosition()).settItems(itemToDrop);
                        System.out.println("You drop the " + itemToDrop + " for the " + item);
                        itemDropped = false;
                        break;
                    } else if (a == pInven.length - 1)
                        System.out.println("I'm not carrying that item");
                }
            } while (itemDropped);
            return pInven;
        }
    }
    return pInven;
}


    public void inputHandler(String temp) throws IOException {
        Validation v = new Validation();
        Selection s = new Selection();
        Scanner input = new Scanner(System.in);
        String itemToDrop;
        boolean itemDropped = false;
        String[] copyOfPlayerInven = Arrays.copyOf(player.getInventory(), 5);
        String[] parts = temp.split(" ");
        switch (parts[0]) {
            case "p": {
                System.out.println(tileRef.get(player.getPosition()).gettDescription());
                System.out.println(tileRef.get(player.getPosition()).gettCart());
                System.out.println(player.getPosition());
                System.out.println(player.isInCart());
                System.out.println(isFuelUsed());
                System.out.println(isCartKeyUsed());
                System.out.println(player.getHealth());
                currentEvent(player);
                calculateDamage(player);


                break;
            }
            case "Move", "move": {
                moveTile(v.validateInput(parts[1]), s.directionSelection(v.validateInput(parts[1]), player));
                System.out.println(tileRef.get(player.getPosition()).gettDescription());
                calculateDamage(player);
                break;
            }
            case "Drop", "drop": {
                player.setInventory(dropItem(v.validateInput(parts[1], player.getInventory()), player.getInventory()));
                calculateDamage(player);
                break;
            }
            case "Pick-up", "pick-up": {
                player.setInventory(pickItem(v.validateInput(parts[1], tileRef.get(player.getPosition()).gettItems()), player.getInventory()));
                calculateDamage(player);
                break;
            }
            case "Use", "use": {
                switch (parts[1]) {
                    case "cart", "Cart": {
                        player.setInCart(useCart(parts[1], tileRef.get(player.getPosition()).gettCart(), player));
                        break;
                    }
                    case "Hazmat", "hazmat": {
                        player.setHasProtectiveClothing(useHazmat(parts[1], player));
                        break;
                    }
                    case "wrench", "Wrench": {
                        setPipelineFixed(useWrench(parts[1], tileRef.get(player.getPosition()).gettIntractable(), player));
                        break;
                    }
                    case "cabinet", "Cabinet", "Table", "table", "Sofa", "sofa": {

                        break;
                    }
                    case "map", "Map", "m": {
                        player.useMapPane(tileRef.get(player.getPosition()));
                        break;
                    }
                }
                calculateDamage(player);
                break;
            }
            case "I", "i":{
                player.printInventory();
                break;
            }
            case "menu", "m", "Menu":{
              //  player.displayMenu();
                Event.displayMenu();
                break;
            }
            case "Q","q","Quit","quit":{
                this.quit = true;
                break;
            }
            case "Exit","exit":{
                if(tileRef.get(player.getPosition()).gettDescription().equalsIgnoreCase("3A")) {
                    this.exitFacility = true;
                    break;
                }else
                    System.out.println("There's no where for me to exit the facility from here");
                break;
            }

            default: {
                System.out.println("Bad Input try again");
                break;
            }
        }
    }
    
      
    


    public static void main(String[] args) throws IOException {
        Map map = new Map();
        Game newGame = new Game();
        Selection s = new Selection();
        Validation v = new Validation();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String temp;
        String go = "start";

        //Intro description before the game begins.
        //user can type start to begin game
        do {
            Event.initialDescription(getPrologue());
            System.out.print(">");

        } while (!go.equalsIgnoreCase(scan.nextLine()));
        System.out.print("\n\nGood Luck\n\n");

        //Prologue
        newGame.player.setPosition(18);
       // System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());

        //Main game loop after intro
        do {
            System.out.println(currentEvent(newGame.player));
            System.out.print(">");
            temp = input.nextLine();
            newGame.inputHandler(temp);


        } while (!newGame.pipelineFixed && newGame.player.isAlive() && !newGame.quit && !newGame.exitFacility);

        //Epilogue
        if (newGame.quit) {
            System.out.println("Quitting Game");
            return;
        } else if (newGame.exitFacility) {
            System.out.println("You leave the facility");
            return;
        } else if (newGame.pipelineFixed) {
            System.out.println("You fix the pipe but are overwhelmed by the radiation");
            return;
        }

    }


}





