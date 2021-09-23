package game;
import java.util.*;
import objects.Player;
import objects.Tile;
import position.Direction;


public class Game {


    /**
     *
     */
    List<String> direct = new ArrayList<>(Arrays.asList("n", "s", "e", "w"));

    public Scanner ChooseDirection(String getDirect) {

        String defMsg = " .";
        defMsg = direct + " That's not a valid direction.";

        if ("n".equals(getDirect)) {
            moveN();
        } else if ("s".equals(getDirect)) {
            moveS();
        } else if ("e".equals(getDirect)) {
            moveE();
        } else if ("w".equals(getDirect)) {
            moveW();
        } else {
            defMsg = "";
        }
        return null;
    }


    private void moveN() {
        upDate(moveTo(player, Direction.NORTH));
    }

    private void moveS() {
        upDate(moveTo(player, Direction.SOUTH));
    }

    private void moveE() {
        upDate(moveTo(player, Direction.EAST));
    }

    private void moveW() {
        upDate(moveTo(player, Direction.WEST));
    }

    public int moveTo(Player player, Direction dir) {

        Tile t = player.getTile();
        int exit;

        if (dir == Direction.NORTH) {
            exit = t.getN();
        } else if (dir == Direction.SOUTH) {
            exit = t.getS();
        } else if (dir == Direction.EAST) {
            exit = t.getE();
        } else if (dir == Direction.WEST) {
            exit = t.getW();
        } else {
            exit = Direction.NOEXIT;
        }
        return exit;
    }


    void upDate(int tileNum) {
        String str;
        if (tileNum == Direction.NOEXIT) {
            str = "You cannot go that way";
        } else {

            player.setTile(grid.get(tileNum));
            System.out.println(player.getTile().getDescribe());
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    private ArrayList<Tile> grid;
    private Player player;

    Scanner s = new Scanner(System.in);


    public Game() {
        this.grid = new ArrayList<Tile>();

        grid.add(new Tile("Control Centre (Tile 4d).", " where the game starts.", Direction.NOEXIT, Direction.NOEXIT, 1, 2));
        grid.add(new Tile("Tile 4c.", " west of Control Centre", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        grid.add(new Tile("Tile 4e.", " east of Control Centre", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0));

        player = new Player("You", "nuclear power plant technician", grid.get(0));
    }


    public void moveNew(int newMove) {

        if (newMove == Direction.NOEXIT) {
            System.out.println("You cannot go that way");

        } else {

        }

    }


    ArrayList getGrid() {
        return grid;
    }

    List<String> getDirect() {
        return direct;
    }






        public static void main (String[] args) {

            Game theGame = new Game();
            System.out.println(theGame.getPlayer().getTile().getDescribe());
            //theGame.ChooseDirection("e");
            System.out.println("Which direction will you travel?");
           Scanner s = new Scanner(System.in);
       //  int newMove = s.nextLine();
        }
    }

