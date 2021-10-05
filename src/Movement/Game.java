package Movement;

//import MultiArray.CalculateDamage;

import java.util.ArrayList;

import java.util.Scanner;

public class Game {


    private ArrayList<Tile> tileRef;
    private Player player;


    public Game() {
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(new Tile("1A", "", "", false, true, true, false, 8));
        this.tileRef.add(new Tile("1B", "", "", false, true, false, true, 8));
        this.tileRef.add(new Tile("1C", "", "", false, false, true, true, 10));
        this.tileRef.add(new Tile("1D(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("1E(Unreachable)", "", "", false, false, false, false, 0));
        //row 2
        this.tileRef.add(new Tile("2A", "", "", true, false, true, false, 6));
        this.tileRef.add(new Tile("2B(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("2C", "", "", true, false, false, false, 10));
        this.tileRef.add(new Tile("2D(Unreachable)", "", "", true, false, false, false, 0));
        this.tileRef.add(new Tile("2E(Unreachable)", "", "", false, false, false, false, 0));
        //row 3
        this.tileRef.add(new Tile("3A(Exit via West)", "", "", true, false, true, false, 6));
        this.tileRef.add(new Tile("3B(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3C(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3D(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3E(Unreachable)", "", "", false, false, false, false, 0));
        //row 4
        this.tileRef.add(new Tile("4A", "", "", true, true, true, false, 5));
        this.tileRef.add(new Tile("4B", "", "", false, true, false, true, 35));
        this.tileRef.add(new Tile("4C(West of Start)", "", "", false, true, false, true, 35));
        this.tileRef.add(new Tile("4D(Start)", "Cart", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("4E(East of Start)", "", "", false, false, true, true, 3));
        //row 5
        this.tileRef.add(new Tile("5A", "", "", true, true, false, false, 3));
        this.tileRef.add(new Tile("5B", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5C", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5D", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5E", "", "", true, false, false, true, 3));

        player = new Player("Tester");


    }

    public void moveTile(String dir, int newTile) {

        //Notes
        //Needs statments for exiting the game at 3a
        //Also needs statments for traveling in the cart 3a-1a,1a-1c

        if (dir.equals("n") && this.tileRef.get(this.player.getPosition()).gettN()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("s") && this.tileRef.get(this.player.getPosition()).gettS()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("e") && this.tileRef.get(this.player.getPosition()).gettE()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("w") && this.tileRef.get(this.player.getPosition()).gettW()) {
            this.player.setPosition(this.player.getPosition() + newTile);
        } else if (dir.equals("badInput")) {
            System.out.println("Bad input try again");
        } else {
            System.out.println("You cannot go that way");
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
        System.out.println("You can't carry anything else");
        return pInven;
        }
        }
        return pInven;
        }


    public static void main(String[] args) {
        Game newGame = new Game();
        Selection s = new Selection();
        Validation v = new Validation();
        Items i = new Items();
        CalculateDamage cd = new CalculateDamage();
        Scanner input = new Scanner(System.in);
        String temp;
        System.out.println(newGame.tileRef);
        System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());
        newGame.tileRef.get(newGame.player.getPosition()).settItems("cart key");
        newGame.tileRef.get(newGame.player.getPosition()).printItems();
        while (true) {
       /*       System.out.println("Enter a direction");
                temp = input.nextLine();
                newGame.moveTile(v.validateInput(temp), s.directionSelection(v.validateInput(temp)));
                System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());*/


            System.out.println("Enter an item to pick up");
            temp = input.nextLine();
            newGame.player.setInventory(newGame.pickItem(v.validateInput(temp, newGame.tileRef.get(newGame.player.getPosition()).gettItems()), newGame.player.getInventory()));
            System.out.println("Enter a direction to move");
            temp = input.nextLine();
            newGame.moveTile(v.validateInput(temp), s.directionSelection(temp));
            System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());
            System.out.println("What would you like to drop");
            temp = input.nextLine();
            newGame.player.setInventory(newGame.dropItem(v.validateInput(temp, newGame.player.getInventory()), newGame.player.getInventory()));
            newGame.tileRef.get(newGame.player.getPosition()).printItems();


        }
    }

}





