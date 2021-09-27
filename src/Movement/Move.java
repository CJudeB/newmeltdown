package Movement;

import java.util.ArrayList;

import java.util.Scanner;

public class Move {


    private ArrayList <Tile> tileRef;
    private Player player;



    public Move(){
        this.tileRef = new ArrayList<Tile>();
        this.tileRef.add(new Tile("West of Start(4C)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("Start(4E)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("East of Start(4D)","table", "lockedDoor", false, false, true,true));
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(new Tile("South of 4E(5E)","table", "lockedDoor", true, false, false,true));

        player = new Player("Tester");

    }

        public void moveTile(String dir, int newTile) {

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
            Move newMove = new Move();
            Selection s = new Selection();
            Validation v =new Validation();
            Scanner input = new Scanner(System.in);
            String temp;

            System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
            while(true) {
                System.out.println("Enter a direction");
                temp = input.nextLine();
                newMove.moveTile(v.validateInput(temp), s.directionSelection(temp));

                System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
            }
        }

    }





