package Movement;

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

    public void removeItems(String item) {

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals(item)) {
                inventory[i] = " ";
                break;
            }
        }
    }


    public void addItems(String item) {

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

    public static void setReactorMap(Map reactorMap) {
        Player.reactorMap = reactorMap;
    }

    public Map getReactorMap() {
        return reactorMap;
    }

    public int getDamVal() {
        return CalculateDamage.getDamVal();
    }


    public void getFinalDam() {
    }

}



