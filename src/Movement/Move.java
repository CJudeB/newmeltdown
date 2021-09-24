package Movement;

import java.util.ArrayList;
import Movement.Selection;
import java.util.Scanner;
import Movement.Tile;
public class Move {


    private ArrayList <Tile> tileRef;
    private Player player;

    public Move(){
        this.tileRef = new ArrayList<Tile>();
        tileRef.add(new Tile("East of Start(4C)","table", "lockedDoor", false, true, false,true));
        tileRef.add(new Tile("Start(4E)","table", "lockedDoor", false, true, false,true));
        tileRef.add(new Tile("West of Start(4E)","table", "lockedDoor", false, false, true,true));
        tileRef.add(new Tile("South of 4E(5E)","table", "lockedDoor", true, false, false,true));

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
            System.out.println(newMove.tileRef);
            System.out.println(newMove.tileRef.get(newMove.player.getPosition()));
            System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
            System.out.println(newMove.tileRef.get(3).gettDescription());
            //System.out.println("Enter a direction");
            //String temp = input.nextLine();
           // newMove.moveTo(newMove.getPlayer(), s.directionSelection(temp));

            //System.out.println(newMove.tileRef.get(newMove.player.getPosition()).gettDescription());
        }

    }





