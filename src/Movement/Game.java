package Movement;

//import MultiArray.CalculateDamage;

import java.util.ArrayList;
import java.util.Scanner;
import static Movement.Items.*;

public class Game {


    private ArrayList<Tile> tileRef;
    private Player player;
    private boolean pipelineFixed = false, quit = false, exitFacility = false;
    public Game() {
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(new Tile("1A", "cart", "", false, true, true, false, 8));
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
        this.tileRef.add(new Tile("3A(Exit via West)", "cart", "", true, false, true, false, 6));
        this.tileRef.add(new Tile("3B(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3C(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3D(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("3E(Unreachable)", "", "", false, false, false, false, 0));
        //row 4
        this.tileRef.add(new Tile("4A", "", "", true, true, true, false, 5));
        this.tileRef.add(new Tile("4B", "", "", false, true, false, true, 35));
        this.tileRef.add(new Tile("4C(West of Start)", "", "", false, true, false, true, 35));
        this.tileRef.add(new Tile("4D(Start)", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("4E(East of Start)", "instruments", "", false, false, true, true, 3));
        //row 5
        this.tileRef.add(new Tile("5A", "", "", true, true, false, false, 3));
        this.tileRef.add(new Tile("5B", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5C", "cabinet", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5D", "", "", false, true, false, true, 3));
        this.tileRef.add(new Tile("5E", "", "", true, false, false, true, 3));

        //Add items to tile 4E
        this.tileRef.get(18).settItems("wrench");
        player = new Player("Tester");
        //Add items to tile 5A
        this.tileRef.get(19).settItems("fuel");
        //Add items to tile 5C
        this.tileRef.get(22).settItems("delimiter");
        this.tileRef.get(22).settItems("cart key");
        this.tileRef.get(22).settItems("protective clothing");

    }

    public void setPipelineFixed(boolean pipelineFixed) {
        this.pipelineFixed = pipelineFixed;
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

        public void inputHandler(String temp){
        Validation v = new Validation();
        Selection s = new Selection();
        String[] parts = temp.split(" ");
        switch(parts[0]){
            case "Move", "move":{
                moveTile(v.validateInput(parts[1]), s.directionSelection(parts[1]));
                System.out.println(tileRef.get(player.getPosition()).gettDescription());
                break;
            }
            case "Drop", "drop":{
                player.setInventory(dropItem(v.validateInput(parts[1], player.getInventory()), player.getInventory()));
                break;
            }
            case "Pick-up", "pick-up":{
                player.setInventory(pickItem(v.validateInput(parts[1], tileRef.get(player.getPosition()).gettItems()), player.getInventory()));
                break;
            }
            case "Use", "use":{
                switch(parts[1]){
                    case "cart","Cart":{
                        player.setInCart(useCart(parts[1], tileRef.get(player.getPosition()).gettIteractable(),player));
                        break;
                    }
                    case "Hazmat", "hazmat":{
                        player.setHasProtectiveClothing(useHazmat(parts[1], player));
                        break;
                    }
                    case "wrench", "Wrench":{
                        setPipelineFixed(useWrench(parts[1], tileRef.get(player.getPosition()).gettIteractable(), player));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Game newGame = new Game();
        Selection s = new Selection();
        Validation v = new Validation();
        Items i = new Items();
        CalculateDamage cd = new CalculateDamage();
        Scanner input = new Scanner(System.in);
        String temp;

        //Main game loop after intro


        do{

            System.out.print(">");
            temp = input.nextLine();
            newGame.inputHandler(temp);
            
        }while(!newGame.pipelineFixed && newGame.player.isAlive() && !newGame.quit && !newGame.exitFacility);

    }

}





