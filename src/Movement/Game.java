package Movement;

//import MultiArray.CalculateDamage;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static Movement.Items.*;
import static Movement.Validation.*;

public class Game {


    private ArrayList<Tile> tileRef;
    private Player player;
    private boolean pipelineFixed = false, quit = false, exitFacility = false;
    private Cart cart;

    public Game() {
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(new Tile("1A", "Stairs", "", false, true, true, false, 8));
        this.tileRef.add(new Tile("1B", "", "", false, true, false, true, 8));
        this.tileRef.add(new Tile("1C", "", "", false, false, true, true, 10));
        this.tileRef.add(new Tile("1D(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("1E(Unreachable)", "", "", false, false, false, false, 0));
        //row 2
        this.tileRef.add(new Tile("2A", "", "", true, false, true, false, 6));
        this.tileRef.add(new Tile("2B(Unreachable)", "", "", false, false, false, false, 0));
        this.tileRef.add(new Tile("2C", "pipeline", "", true, false, false, false, 10));
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

        //Add items to tile 4D
        this.tileRef.get(18).settItems("wrench");
        //Add items to tile 5A
        this.tileRef.get(19).settItems("fuel");
        //Add items to tile 5C
        this.tileRef.get(22).settItems("delimiter");
        this.tileRef.get(22).settItems("cart-key");
        this.tileRef.get(22).settItems("Hazmat");

        //Test items
        this.tileRef.get(10).settItems("fuel");
        this.tileRef.get(10).settItems("cart-key");
        this.tileRef.get(10).settItems("delimiter");
        this.tileRef.get(10).settItems("Med-kit");
        this.tileRef.get(10).settItems("Hazmat");
        this.tileRef.get(10).settItems("wrench");

        //Create player
        player = new Player("Tester");
        //Create Cart
        cart = new Cart();
    }

    public void setPipelineFixed(boolean pipelineFixed) {
        this.pipelineFixed = pipelineFixed;
    }

    public void moveTile(String dir, int newTile) {


        //Removing cart from tile if needed
        if(player.isInCart() && !(player.getPosition() == 10 || player.getPosition() == 2)){
            tileRef.get(player.getPosition()).settIntractable("");
        }else if(player.isInCart() && player.getPosition() == 10 && dir.equals("n")){
            tileRef.get(player.getPosition()).settIntractable("");
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
        if(player.isInCart() && !(player.getPosition() == 15 || player.getPosition() == 7)){
            tileRef.get(player.getPosition()).settIntractable("cart");
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


        public void inputHandler(String temp){
        Validation v = new Validation();
        Selection s = new Selection();
        Scanner input = new Scanner(System.in);
        String itemToDrop;
        boolean itemDropped = false;
        String [] copyOfPlayerInven = Arrays.copyOf(player.getInventory(),5);
        String[] parts = temp.split(" ");
        switch(parts[0]){
            case "p":{
                System.out.println(tileRef.get(player.getPosition()).gettDescription());
                System.out.println(tileRef.get(player.getPosition()).gettIntractable());
                System.out.println(player.getPosition());
                System.out.println(player.isInCart());
                System.out.println(cart.isFuelUsed());
                System.out.println(cart.isCartKeyUsed());
                break;
            }
            case "Move", "move":{
                moveTile(v.validateInput(parts[1]), s.directionSelection(v.validateInput(parts[1]),player));
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
                        player.setInCart(cart.useCart(parts[1], tileRef.get(player.getPosition()).gettIntractable(),player));
                        break;
                    }
                    case "Hazmat", "hazmat":{
                        player.setHasProtectiveClothing(useHazmat(parts[1], player));
                        break;
                    }
                    case "wrench", "Wrench":{
                            setPipelineFixed(useWrench(parts[1], tileRef.get(player.getPosition()).gettIntractable(), player));
                            break;
                    }
                }
                break;
            }
            case "I", "i":{
                player.printInventory();
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

            default:{
                System.out.println("Bad Input try again");
                break;
            }
        }
    }


    public static void main(String[] args) {
        Game newGame = new Game();
        Selection s = new Selection();
        Validation v = new Validation();
        CalculateDamage cd = new CalculateDamage();
        Scanner input = new Scanner(System.in);
        String temp;


        //Prologue
        newGame.player.setPosition(10);
        System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());

        //Main game loop after intro
        do{

            System.out.print(">");
            temp = input.nextLine();
            newGame.inputHandler(temp);
            newGame.player.setInCart(onCartTile(newGame.player.getPosition(), newGame.player));

        }while(!newGame.pipelineFixed && newGame.player.isAlive() && !newGame.quit && !newGame.exitFacility);

        //Epilogue
        if(newGame.quit){
            System.out.println("Quitting Game");
            return;
        }else if(newGame.exitFacility){
            System.out.println("You leave the facility");
            return;
        }else if(newGame.pipelineFixed){
            System.out.println("You fix the pipe but are overwhelmed by the radiation");
            return;
        }

    }

}





