package Movement;

import java.util.ArrayList;

import java.util.Scanner;

public class Move {


    private ArrayList <Tile> tileRef;
    private Player player;

    

    public Move(){
        this.tileRef = new ArrayList<Tile>();
        this.tileRef.add(new Tile("East of Start(4C)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("Start(4E)","table", "lockedDoor", false, true, false,true));
        this.tileRef.add(new Tile("West of Start(4D)","table", "lockedDoor", false, false, true,true));
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(null);
        this.tileRef.add(new Tile("South of 4E(5E)","table", "lockedDoor", true, false, false,true));

        player = new Player("Tester");

    }

    public Player getPlayer() {
        return player;
    }

    public void moveTo(Player player, int newTile){

                player.setPosition(player.getPosition() + newTile);

        }




        public static void main(String[] args) {
            Move newMove = new Move();
            Selection s = new Selection();
            Scanner input = new Scanner(System.in);


            System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
            while(true) {
                System.out.println("Enter a direction");
                newMove.moveTo(newMove.getPlayer(), s.directionSelection(input.nextLine()));

                System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
            }
        }

    }





