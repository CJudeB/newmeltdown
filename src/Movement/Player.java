package Movement;

public class Player<displayM> {


    private String name;
    private int Position, health = 100;
    private boolean inCart = false, hasProtectiveClothing = false, isAlive = true;
    private String[] inventory = new String[5];
    private Map mapPane;


    public Player(String name) {
        this.name = name;
        this.Position = 18;

    }


    public Player() {

    }


    public int getPosition() {return Position;}

    public void setPosition(int Position) {
        this.Position = Position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
    public void setHasProtectiveClothing(boolean hasProtectiveClothing) {
        this.hasProtectiveClothing = hasProtectiveClothing;
    }

    public Map getMapPane(){ return mapPane; }



    public void setMapPane(Map mapPane) {
       this.mapPane = mapPane;
    }



    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }
    public void removeItems(String item){
        for( int  i = 0 ; i < inventory.length; i++){
            if(inventory[i].equalsIgnoreCase(item)){
                this.inventory[i] ="";
            }
        }
    }


    public void printInventory(){
        for (int i = 0; i < inventory.length ; i++) {
            if (!(inventory[i] == null)) {
                System.out.print("Inventory: ");
                break;
            } else if (i == inventory.length - 1) {
                System.out.println("I don't have anything on me");
                break;
            }
        }
        for (String i:inventory) {
            if(!(i == null)) {
                System.out.print(i + " | ");
            }

        }
        System.out.print("\n");
    }




    public void useMapPane(Tile tile) {
    }

    public void displayMenu() {
        String displayM;
        displayM = (String) getTiles().get("25");
        System.out.println(displayM);
    }

    private java.util.Map<Object, Object> getTiles() {
        return null;
    }
}



