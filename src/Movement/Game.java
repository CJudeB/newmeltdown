package Movement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Movement.CalculateDamage.calculateDamage;
import static Movement.Cart.*;
import static Movement.Event.currentEvent;
import static Movement.Items.useHazmat;
import static Movement.Items.useWrench;


public class Game {

    private int health;
    private Map reactorMap;
    private ArrayList<Tile> tileRef;
    private Player player;
    private boolean pipelineFixed = false, quit = false, exitFacility = false, catwalk = false;
    Map map = new Map();

    /**
     * Instantiates a new Game.
     * Creates all tiles through the Tile constructor
     * Sets static items into tiles
     * Creates a new player for the game instance
     */
    public Game() throws IOException {
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(new Tile("1.1A", "Stairs", "", false, false, true, true, false, 6));
        this.tileRef.add(new Tile("2.1B", "", "", false, false, true, false, true, 6));
        this.tileRef.add(new Tile("3.1C", "", "", false, false, false, true, true, 6));
        this.tileRef.add(new Tile("1D(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("1E(Unreachable)", "", "", false, false, false, false, false, 0));
        //row 2
        this.tileRef.add(new Tile("2A", "", "", false, true, false, true, false, 6));
        this.tileRef.add(new Tile("2B(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("2C", "pipeline", "", false, true, false, false, false, 10));
        this.tileRef.add(new Tile("2D(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("2E(Unreachable)", "", "", false, false, false, false, false, 0));
        //row 3
        this.tileRef.add(new Tile("3A(Exit via West)", "", "cart", false, true, false, true, false, 5));
        this.tileRef.add(new Tile("3B(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("3C(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("3D(Unreachable)", "", "", false, false, false, false, false, 0));
        this.tileRef.add(new Tile("3E(Unreachable)", "", "", false, false, false, false, false, 0));
        //row 4
        this.tileRef.add(new Tile("15.4A", "", "", false, true, true, true, false, 5));
        this.tileRef.add(new Tile("16.4B", "", "", false, false, true, false, true, 25));
        this.tileRef.add(new Tile("17.4C(West of Start)", "", "", false, false, true, false, true, 25));
        this.tileRef.add(new Tile("18.4D(Start)", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("19.4E(East of Start)", "instruments", "", false, false, false, true, true, 3));
        //row 5
        this.tileRef.add(new Tile("20.5A", "", "", false, true, true, false, false, 3));
        this.tileRef.add(new Tile("21.5B", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("22.5C", "cabinet", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("23.5D", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("24.5E", "", "", false, true, false, false, true, 3));

        //Add items to tile 4E
        this.tileRef.get(19).settItems("wrench");
        //Add items to tile 4D
        this.tileRef.get(18).settItems("map");
        //Add items to tile 5A
        this.tileRef.get(20).settItems("fuel");
        //Add items to tile 5C
        this.tileRef.get(22).settItems("cart-key");
        this.tileRef.get(22).settItems("Hazmat");

        //Test items
        this.tileRef.get(10).settItems("cart-key");
        this.tileRef.get(10).settItems("fuel");
        this.tileRef.get(10).settItems("Hazmat");
        //Create player
        player = new Player("Tester", health);

    }

    /**
     * Sets pipeline fixed.
     *
     * @param pipelineFixed takes in a boolean which comes from the method useWrench
     */
    public void setPipelineFixed(boolean pipelineFixed) {
        this.pipelineFixed = pipelineFixed;
    }

    /**
     * Move tile. Changes the value of the players position with reference to the tile array,
     * It also moves the carts position around the array if the player is in it. Also does Radiation damage
     * to the player after they move through calculateDamage
     *
     * @param dir     The direction the player intends to move comes from validation class
     * @param newTile The integer value to move within the array comes from the selection class
     */
    public void moveTile(String dir, int newTile) {


        //Removing cart from tile if needed
        if (player.isInCart() && !(player.getPosition() == 2)) {
            tileRef.get(player.getPosition()).settCart("");
        }
        //Set tile visited to true before leaving it.
        if (!(tileRef.get(player.getPosition()).isHasVisited())) {
            tileRef.get(player.getPosition()).setHasVisited(true);
        }

        //Move the player from one space to the next if possible otherwise tell them they can't
        if (dir.equals("n") && this.tileRef.get(this.player.getPosition()).gettN()) {
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("s") && this.tileRef.get(this.player.getPosition()).gettS()) {
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("e") && this.tileRef.get(this.player.getPosition()).gettE()) {
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("w") && this.tileRef.get(this.player.getPosition()).gettW()) {
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("badInput")) {
            System.out.println("That's not a direction I can move");
        } else {
            System.out.println("You cannot go that way");
        }
        //Setting cart into tile if needed
        if (player.isInCart() && !(player.getPosition() == 7)) {
            tileRef.get(player.getPosition()).settCart("cart");
        }
    }


    /**
     * Drop item. Drops the selected item if it exists in the player inventory. Also does Radiation damage
     * to the player after they drop an item through calculateDamage
     *
     * @param item the item that is entered in after the drop key word
     */
    public void dropItem(String item) {
        //If validate returns badInput print
        if (item.equals("badInput")) {
            System.out.println("You aren't holding a item like that");
        } else if (item.equals("hazmat")) {
            System.out.println("It would be a bad idea to take the radiation suit off");
        } else {
            player.removeItems(item);
            System.out.println("You dropped the " + item);
            this.tileRef.get(this.player.getPosition()).settItems(item);
            calculateDamage(player, tileRef.get(player.getPosition()));
        }
    }


    /**
     * Picks up the selected item from the tile if it exists within the tiles items array
     * Also does Radiation damage to the player after they pick up an item through calculateDamage
     *
     * @param item   the item that is entered in after the drop key word
     * @param pInven the players inventory
     * @return the string [ ], returned to be set as the player inventory
     */
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
            if (pInven[i].equals(" ")) {
                pInven[i] = item;
                this.tileRef.get(this.player.getPosition()).removeItem(item);
                System.out.println("You picked up the " + item);
                calculateDamage(player, tileRef.get(player.getPosition()));
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
                            calculateDamage(player, tileRef.get(player.getPosition()));
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


    /**
     * Input handler. Handles the user input by splitting the scanner in string into two words,
     * the first is the key word used to define what action the user wants to take. The second is what item
     * the user wants to interact with. Each case calls a method or set of methods to handle each situation.
     *
     * @param temp the temporary storage for user inputs.
     */
    public void inputHandler(String temp) throws IOException {
        Validation v = new Validation();
        Selection s = new Selection();
        String[] parts = temp.split(" ");
        switch (parts[0]) {
            case "p": {
          /*    System.out.println(tileRef.get(player.getPosition()).gettDescription());
                System.out.println(tileRef.get(player.getPosition()).gettCart());
                tileRef.get(player.getPosition()).printItems();
                System.out.println(player.isInCart());
                System.out.println(isFuelUsed());
                System.out.println(isCartKeyUsed());
                System.out.println(tileRef.get(player.getPosition()).isHasVisited());


               currentEvent(player, tileRef.get(player.getPosition()).isHasVisited());
                System.out.println(player.getHealth()); // this is returning correct value
                System.out.println(player.getDamVal()); //is not passing damVal to Calculate Damage. this is here for testing if I decide to fix*/
                System.out.println(player.getHealth());
                break;

            }
            case "Move", "move": {
                moveTile(v.validateInput(parts[1]), s.directionSelection(v.validateInput(parts[1]), player));
                currentEvent(player, tileRef.get(player.getPosition()).isHasVisited()); // this prints out tile location need to replace with event
                break;
            }
            case "Drop", "drop": {
                dropItem(v.validateInput(parts[1], player.getInventory()));
                break;
            }
            case "Pick-up", "pick-up": {
                player.setInventory(pickItem(v.validateInput(parts[1], tileRef.get(player.getPosition()).gettItems()), player.getInventory()));
                break;
            }
            case "Use", "use": {
                switch (parts[1]) {
                    case "cart", "Cart": {
                        player.setInCart(useCart(parts[1], tileRef.get(player.getPosition()).gettCart(), player, tileRef.get(player.getPosition())));
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
                    case "map", "Map": {
                        this.map.displayMap(parts[1], player);
                        break;
                    }
                }
                break;
            }
            case "I", "i": {
                player.printInventory();
                break;
            }
            case "Q", "q", "Quit", "quit": {
                this.quit = true;
                break;
            }
            case "Exit", "exit": {
                if (tileRef.get(player.getPosition()).gettDescription().equalsIgnoreCase("3A")) {
                    this.exitFacility = true;
                    break;
                } else
                    System.out.println("There's no where for me to exit the facility from here");
                break;
            }
            case "Yes", "yes", "No", "no": {
                if ((parts[0].equalsIgnoreCase("yes") && (player.getPosition()) == 0)) {
                    catwalk = true;
                } else {
                    System.out.println("You move back down the stairs.");
                }
                break;
            }
            default: {
                System.out.println("Bad Input try again");
                break;
            }
        }
    }


    /**
     * The entry point of application. Has three sections the prologue which is a cutscene to introduce the story.
     * The main game loop that occurs until an exit condition is met.
     * The epilogue; after an exit condition is meet an outro cutscene occurs before the game ends
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException {
        Game newGame = new Game();
        Selection s = new Selection();
        Validation v = new Validation();
        CalculateDamage cd = new CalculateDamage();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String temp;
        String go = "start";

        //Intro description before the game begins.
        //To begin game user types start
        do {
            Event.initialDescription();
            System.out.print(">");
        } while (!go.equalsIgnoreCase(scan.nextLine()));
        System.out.print("\n\nGood Luck\n\n");

        //Prologue

        newGame.player.setPosition(18);
        System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());

        //Main game loop after intro
        do {

            System.out.print(">");
            temp = input.nextLine();
            newGame.inputHandler(temp);

        } while (!newGame.pipelineFixed && newGame.player.alive() && !newGame.quit && !newGame.exitFacility && !newGame.catwalk);

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
        } else if (newGame.catwalk) {
            System.out.println("You walk up the 4 flights of stairs to the кошачья прогулка. \nAs you move towards the cooling tower, each step you take becomes more cumbersome. \nYou're head is splitting with pain. \nYou push on reaching the tower." +
                    "\nYou fall against the rail, you can barely stand. \nThe rail creaks and bends weakened by the explosion, it can no longer support your weight. \nThe rail fails completely and you plummet from the кошачья прогулка. SPLAT!!!!");
            return;
        } else if (!newGame.player.alive()) {
            System.out.println("You died. Game over.");
            return;
        }
    }
}





