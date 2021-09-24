package game;
import java.util.*;
import objects.Player;
import objects.Tile;
import position.Direction;
import objects.Validation;

public class Game {
    //Game variables
    private ArrayList<Tile> grid;
    private Player player;
    private boolean inPlay = true;

    //Game constructor
    public Game() {
        this.grid = new ArrayList<Tile>();

        grid.add(new Tile("Control Centre (Tile 4d).", " where the game starts.", Direction.NOEXIT, Direction.NOEXIT, 2, 1));
        grid.add(new Tile("Tile 4c.", " west of Control Centre", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        grid.add(new Tile("Tile 4e.", " east of Control Centre", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0));

        player = new Player("You", "nuclear power plant technician", grid.get(0));
    }

    //Getters
    public Player getPlayer() {
        return player;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    ArrayList getGrid() {
        return grid;
    }

    //setters
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    //Choose method to change position
    public void ChooseDirection(String getDirect) {

        if ("n".equals(getDirect)) {
            moveN();
        } else if ("s".equals(getDirect)) {
            moveS();
        } else if ("e".equals(getDirect)) {
            moveE();
        } else if ("w".equals(getDirect)) {
            moveW();
        }else{
            System.out.println("Invalid Input");
        }

    }

    //Call positon updaters with parameters
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

    //Select tile number of next tile
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

    //Update the player position
    void upDate(int tileNum) {
        String str;
        if (tileNum == Direction.NOEXIT) {
            System.out.println("You cannot go that way");
        } else {

            player.setTile(grid.get(tileNum));
            System.out.println(player.getTile().getDescribe());
        }
    }


        public static void main (String[] args) {


            Game theGame = new Game();
            Scanner s = new Scanner(System.in);
            Validation v = new Validation();



            System.out.println(theGame.getPlayer().getTile().getDescribe());

            while(theGame.isInPlay()) {
                System.out.println("Which direction will you travel?");
                theGame.ChooseDirection(v.validateInput(s.nextLine()));

            }

    }
    }

