package Movement;

import java.util.Scanner;

import static Movement.CalculateDamage.calculateDamage;

public class Player {


    private final String name;
    static Map reactorMap;
    private boolean alive = true;
    private boolean inCart = false;
    private int Position, health = 100;
    private static String printHealth;
    private boolean hasProtectiveClothing = false;
    private String[] inventory = {" ", " ", " ", " ", " "};


    public Player(String name, int health) {
        this.name = name;
        int health1 = this.health;
        this.Position = 18;


    }

    public String methodPrintHealth(String printHealth) {
        printHealth = Integer.toString(getHealth());
        return printHealth;
    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getPrintHealth() {
        return printHealth;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int Position) {
        this.Position = Position;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public boolean isHasProtectiveClothing() {
        return hasProtectiveClothing;
    }


    public void setPrintHealth(String printHealth) {
        Player.printHealth = printHealth;
    }


    public void setHasProtectiveClothing(boolean hasProtectiveClothing) {
        this.hasProtectiveClothing = hasProtectiveClothing;
    }

    //  public void setAlive (boolean alive) {
    //    this.alive = alive;
    // }
    public boolean alive() {
        return health >= 1;
    }

  /* public void isAlive(boolean alive) {

        if (health >= 1) {
            isAlive = alive;
        }
   } */

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Drop item. Drops the selected item if it exists in the player inventory. Also does Radiation damage
     * to the player after they drop an item through calculateDamage
     *
     * @param item the item that is entered in after the drop key word
     */
    public void removeItems(String item ,Tile tile, Player player) {
        if (item.equals("badInput")) {
            System.out.println("You aren't holding a item like that");
        } else if (item.equals("hazmat")) {
            System.out.println("It would be a bad idea to take the radiation suit off");
        } else {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i].equals(item)) {
                    inventory[i] = " ";
                    System.out.println("You dropped the " + item);
                    tile.settItems(item);
                    calculateDamage(player, tile);
                    break;
                }
            }
        }
    }

    /**
     * Remove items. For use within other methods where print-outs aren't needed
     *
     * @param item the item
     */
    public void removeItems(String item){
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals(item)) {
                inventory[i] = " ";
                break;
            }
        }

    }

    /**
     * Picks up the selected item from the tile if it exists within the tiles items array
     * Also does Radiation damage to the player after they pick up an item through calculateDamage
     *
     * @param item   the item that is entered in after the drop key word
     */
    public void addItems(String item, Tile tile, Player player) {
        String itemToDrop;
        boolean itemDropped = true;
        Scanner input = new Scanner(System.in);
        if (item.equals("badInput")) {
            System.out.println("There doesn't seem to be an item like that here");
        }
        else {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i].equals(" ")) {
                    inventory[i] = item;
                    tile.removeItem(item);
                    System.out.println("You picked up the " + item);
                    calculateDamage(player, tile);
                    break;
                } else if (i == inventory.length - 1) {
                    System.out.println("" +
                            "You’re feeling very weak – there’s no way you can carry more. " +
                            "'Why am I carrying all this stuff', you think to yourself." +
                            "");
                    System.out.println("What should I drop for the item? (type name of item");
                    printInventory();
                    do {
                        System.out.print(">");
                        itemToDrop = input.nextLine();
                        for (int a = 0; a < inventory.length; a++) {
                            if (inventory[a].equalsIgnoreCase(itemToDrop)) {
                                inventory[a] = item;
                                tile.settItems(itemToDrop);
                                System.out.println("You drop the " + itemToDrop + " for the " + item);
                                itemDropped = false;
                                calculateDamage(player, tile);
                                break;
                            } else if (a == inventory.length - 1)
                                System.out.println("I'm not carrying that item");
                        }
                    } while (itemDropped);

                }
            }
        }
    }


    /**
     * Add items. For use within other methods where print-outs aren't needed
     *
     * @param item the item
     */
    public void addItems(String item){
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals(" ")) {
                inventory[i] = item;
                break;
            }
        }
    }

    public void printInventory() {
        for (int i = 0; i < inventory.length; i++) {
            if (!(inventory[i] == " ")) {
                System.out.print("Inventory: ");
                break;
            } else if (i == inventory.length - 1) {
                System.out.println("I don't have anything on me");
                break;
            }
        }
        for (String i : inventory) {
            if (!(i == " ")) {
                System.out.print(i + " | ");
            }

        }
        System.out.print("\n");
    }

    public int getDamVal() {
        return CalculateDamage.getDamVal();
    }


    public void getFinalDam() {
    }

}



