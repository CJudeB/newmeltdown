package Movement;

import java.util.ArrayList;

import java.util.Scanner;

public class Game {


    private ArrayList <Tile> tileRef;
    private Player player;



    public Game(){
        this.tileRef = new ArrayList<Tile>();
        //row 1
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        //row 2
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        //row 3
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        //row 4
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(new Tile("West of Start(4C)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("Start(4D)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("East of Start(4E)","table", "lockedDoor", false, false, true,true));
        //row 5
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(new Tile("South of 4E(5E)","table", "lockedDoor", true, false, false,true));

        player = new Player("Tester");

    }

        public void moveTile(String dir, int newTile) {

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
            } else if(dir.equals("badInput")){
                System.out.println("Bad input try again");
            } else {
                System.out.println("You cannot go that way");
            }
        }


        public static void main(String[] args) {
            Game newGame = new Game();
            Selection s = new Selection();
            Validation v = new Validation();
            Scanner input = new Scanner(System.in);
            String temp;

            System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());
            while(true) {
                System.out.println("Enter a direction");
                temp = input.nextLine();
                newGame.moveTile(v.validateInput(temp), s.directionSelection(temp));

                System.out.println(newGame.tileRef.get(newGame.player.getPosition()).gettDescription());
            }
        }

    }





