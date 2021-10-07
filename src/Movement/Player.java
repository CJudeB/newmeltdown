package Movement;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Player {


    private String name;
    private int Position, health = 100;
    private boolean inCart = false, hasProtectiveClothing = false, isAlive = true;
    private String[] inventory = new String[5];


    public Player(String name) {
        this.name = name;
        this.Position = 18;
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
        for (String i:inventory) {
            if(!(i == null)) {
                System.out.print("Inventory: ");
            }else{
                System.out.println("I don't have anything on me");
            }
            break;
        }
        for (String i:inventory) {
            if(!(i == null)) {
                System.out.print(i + " | ");
            }
        }
    }
}



