package Movement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Movement.CalculateDamage.calculateDamage;
import static Movement.Cart.*;
import static Movement.Event.currentEvent;
import static Movement.Items.*;

public class Game {

    public void setHealth(int health) {
        this.health = health;
    }

    private int health;
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
        this.tileRef.add(new Tile("1.1A", "stairs", "", false, false, true, true, false, 6));
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
        this.tileRef.add(new Tile("16.4B", "", "", false, false, true, false, true, 15));
        this.tileRef.add(new Tile("17.4C(West of Start)", "", "", false, false, true, false, true, 15));
        this.tileRef.add(new Tile("18.4D(Start)", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("19.4E(East of Start)", "core-regulator", "", false, false, false, true, true, 3));
        //row 5
        this.tileRef.add(new Tile("20.5A", "", "", false, true, true, false, false, 3));
        this.tileRef.add(new Tile("21.5B", "cabinet", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("22.5C", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("23.5D", "", "", false, false, true, false, true, 3));
        this.tileRef.add(new Tile("24.5E", "npc", "", false, true, false, false, true, 3));

        //Add items to tile 4D
        this.tileRef.get(18).settItems("map");
        //Add items to tile 5A
        this.tileRef.get(20).settItems("jerry-can");
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
     * to the player after they move through calculateDamage. through the tileVisited method will set the tiles
     * has visited variable to true before leaving
     *
     * @param dir     The direction the player intends to move comes from validation class
     * @param newTile The integer value to move within the array comes from the selection class
     */
    public void moveTile(String dir, int newTile) {


        //Removing cart from tile if needed
        if (player.isInCart() && !(player.getPosition() == 2)) {
            tileRef.get(player.getPosition()).settCart("");
        }

        //Move the player from one space to the next if possible otherwise tell them they can't
        if (dir.equals("n") && this.tileRef.get(this.player.getPosition()).gettN()) {
            this.tileRef.get(player.getPosition()).setHasVisited(true);
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("s") && this.tileRef.get(this.player.getPosition()).gettS()) {
            this.tileRef.get(player.getPosition()).setHasVisited(true);
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("e") && this.tileRef.get(this.player.getPosition()).gettE()) {
            this.tileRef.get(player.getPosition()).setHasVisited(true);
            this.player.setPosition(this.player.getPosition() + newTile);
            calculateDamage(player, tileRef.get(player.getPosition()));
        } else if (dir.equals("w") && this.tileRef.get(this.player.getPosition()).gettW()) {
            this.tileRef.get(player.getPosition()).setHasVisited(true);
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
     * Input handler. Handles the user input by splitting the scanner in string into two words,
     * the first is the key word used to define what action the user wants to take. The second is what item
     * the user wants to interact with. Each case calls a method or set of methods to handle each situation.
     *
     * @param temp the temporary storage for user inputs.
     */
    public void inputHandler(String temp) {
        Validation v = new Validation();
        Selection s = new Selection();
        String[] parts = temp.split(" ");
        switch (parts[0]) {
            case "p": {
                break;

            }
            case "Move", "move": {
                moveTile(v.validateInput(parts[1]), s.directionSelection(v.validateInput(parts[1]), player));
                currentEvent(player, tileRef.get(player.getPosition()).isHasVisited(), tileRef.get(player.getPosition())); // this prints out tile location need to replace with event
                break;
            }
            case "Drop", "drop": {
                player.removeItems(v.validateInput(parts[1], player.getInventory()), tileRef.get(player.getPosition()),player);
                break;
            }
            case "Pick-up", "pick-up": {
                player.addItems(v.validateInput(parts[1], tileRef.get(player.getPosition()).gettItems()), tileRef.get(player.getPosition()), player );
                break;
            }
            case "Use", "use": {
                switch (parts[1]) {
                    case "cart", "Cart": {
                        player.setInCart(useCart(parts[1], tileRef.get(player.getPosition()).gettCart(), player, tileRef.get(player.getPosition())));
                        break;
                    }
                    case "wrench", "Wrench": {
                        setPipelineFixed(useWrench(parts[1], tileRef.get(player.getPosition()), player));
                        break;
                    }
                    case "core-regulator", "Core-Regulator", "Core-regulator": {
                        useCoreRegulator(parts[1], tileRef.get(player.getPosition()), player);
                        break;
                    }
                    case "cabinet", "Cabinet": {
                        useCabinets(parts[1],tileRef.get(player.getPosition()),player);
                        break;
                    }
                    case "map", "Map": {
                        this.map.displayMap(parts[1], player);
                        break;
                    }
                    default: {
                        System.out.println("It doesn't look like I can use that.");
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
            case "help", "h", "Help", "H":{
                //  player.displayMenu();
                Event.displayMenu();
                break;
            }
            case "Exit", "exit": {
                if ((player.getPosition()) == 10) {
                    this.exitFacility = true;
                    break;
                } else
                    System.out.println("There's no where for me to exit the facility from here");
                break;
            }
            case "Yes", "yes": {
                if ((player.getPosition()) == 0) {
                    catwalk = true;
                }
                break;
            }
            case "OK", "ok", "Ok", "k": {
                if ((player.getPosition()) == 24) {
                    player.addItems("wrench");
                    System.out.println("""
                                    
                    You have to yell over the siren, 'OK, you will try'.
                    He nods in relief, hands you a wrench, and then passes out.
                    
                    You can move to the west down the hall or north.
                    
                    """);
                   // npc = true;
                }
                break;
            }
            default: {
                System.out.println("Bad Input try again");
                break;
            }
        }
    }
  /* public void damArray() {

        int iterator = getHealth(health);
        int i, j;
        for (i = 1; i <= 1; i++) {
            for (j = 1; j <= iterator; j++) {
                System.out.print(
                        "|" + " "
                );
            }
         //   System.out.println(" HEALTH");
        }
    }*/

    public int getHealth(int health) {
        return health;
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
        currentEvent(newGame.player, newGame.tileRef.get(newGame.player.getPosition()).isHasVisited(), newGame.tileRef.get(newGame.player.getPosition()));

        //Main game loop after intro
        do {

            System.out.print(">");
            temp = input.nextLine();
           // newGame.damArray();
            newGame.inputHandler(temp);
/**
 *
 *@param alive while true loop continues.
 *@param exitFacility story ending
 *@param catwalk dying on catwalk
 *@param pipelineFixed saving the day
 *@param quit user quits*/

        } while (!newGame.pipelineFixed && newGame.player.alive() && !newGame.quit && !newGame.exitFacility && !newGame.catwalk);

        //Epilogue
        if (newGame.quit) {
            System.out.println("Quitting Game.");
        } else if (newGame.exitFacility) {
            System.out.println("""
                    
                    You exit the facility and stumble toward the military medics waiting there.
                    
                    You notice they don't dare move toward the facility from their position, radiation readings must be through the roof.
                    Only minutes after you reach them - while being grilled by a official from the ministry of Electrification,
                    you hear the sickening boom of an explosion at the plant - and only moments after that, everyone and everything within
                    a 50 kilometer radius of the plant is annihilated by the first of many explosions caused by the ensuing meltdown.
                    
                                             ##### #    # ######    ###### #    # ##### \s
                                               #   #    # #         #      ##   # #    #\s
                                               #   ###### #####     #####  # #  # #    #\s
                                               #   #    # #         #      #  # # #    #\s
                                               #   #    # #         #      #   ## #    #\s
                                               #   #    # ######    ###### #    # ##### \s
                    
                    """);

        } else if (newGame.pipelineFixed) {
            System.out.println("""
                                        
                    The wrench fits. After a struggle you are able to repair the pipe.
                    You hear the coolant stream back into the system.
                                        
                    Your eyes shut and you drift back into oblivion, but a deeper kind this time, the kind no siren will wake you from.

                                             ##### #    # ######    ###### #    # ##### \s
                                               #   #    # #         #      ##   # #    #\s
                                               #   ###### #####     #####  # #  # #    #\s
                                               #   #    # #         #      #  # # #    #\s
                                               #   #    # #         #      #   ## #    #\s
                                               #   #    # ######    ###### #    # ##### \s
                                             
                                        
                    """);
        } else if (newGame.catwalk) {
            System.out.println("""
                    
                    You walk up the long flight of stairs to the bridge. You are dismayed to see it is nothing more than a narrow catwalk.
                    
                    As you move towards the reactor, each step you take becomes more cumbersome. Your head is splitting with pain.
                    You notice the rail bending, weakened by the explosion, straining to support your weight.
                    
                    A moment later the rail fails completely and you slip and too weak to grab hold of anything, you fall to your death.
                    
                                             ##### #    # ######    ###### #    # ##### \s
                                               #   #    # #         #      ##   # #    #\s
                                               #   ###### #####     #####  # #  # #    #\s
                                               #   #    # #         #      #  # # #    #\s
                                               #   #    # #         #      #   ## #    #\s
                                               #   #    # ######    ###### #    # ##### \s
                    
                    """);
        } else if (!newGame.player.alive()) {
            System.out.println("""
                    
                    You died. Game Over.
                    
                                             ##### #    # ######    ###### #    # ##### \s
                                               #   #    # #         #      ##   # #    #\s
                                               #   ###### #####     #####  # #  # #    #\s
                                               #   #    # #         #      #  # # #    #\s
                                               #   #    # #         #      #   ## #    #\s
                                               #   #    # ######    ###### #    # ##### \s
                    
                    """);

        }
    }
}





