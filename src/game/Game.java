package game;
import java.io.IOException;
import java.util.*;
import objects.Player;
import objects.Tile;
import position.Direct;

import java.io.BufferedReader;

import java.io.InputStreamReader;


public class Game {


    private ArrayList<Tile> grid;
    private Player player;

    List<String> direct = new ArrayList<>(Arrays.asList("n", "s", "e", "w"));

    public Game() {
        this.grid = new ArrayList<Tile>();

        grid.add(new Tile("Control Centre (Tile 4d).", " where the game starts.", Direct.NOX, Direct.NOX, 1, 2));
        grid.add(new Tile("Tile 4c.", " West of Control Centre", Direct.NOX, Direct.NOX, 0, 0));
        grid.add(new Tile("Tile 4e.", " East of Control Centre", Direct.NOX, 2, 0, Direct.NOX));
        grid.add(new Tile("Tile 4b,", " east of Control Centre", 1, Direct.NOX, Direct.NOX, 0));
        grid.add(new Tile("Tile 4a.", " east of Control Centre", Direct.NOX, Direct.NOX, Direct.NOX, 0));


        player = new Player("You", "nuclear power plant technician", grid.get(0));

    }

    ArrayList getGrid() {
        return grid;
    }

    void setGrid(ArrayList theGrid) {
        grid = theGrid;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player thePlayer) {
        player = thePlayer;

    }
    void movePlayer(Player p, Tile theTile) {
        p.setTile(theTile);
    }

    int movePlayerTo(Player player, Direct dir) {

        Tile t = player.getTile();
        int exit = switch (dir) {
            case NORTH -> t.getN();
            case SOUTH -> t.getS();
            case EAST -> t.getE();
            case WEST -> t.getW();
            default -> Direct.NOX; // noexit - stay in same room
        };

        if (exit != Direct.NOX) {
            movePlayer(player, grid.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direct dir) {

        return movePlayerTo(player, dir);
    }


    private void moveN() {
        upDate(movePlayerTo(Direct.NORTH));
    }

    private void moveS() {
        upDate(movePlayerTo(Direct.SOUTH));
    }

    private void moveE() {
        upDate(movePlayerTo(Direct.EAST));
    }

    private void moveW() {
        upDate(movePlayerTo(Direct.WEST));
    }

    void upDate(int tileNum) {
        String str;
        if (tileNum == Direct.NOX) {
            str = "You cannot go that way";
        } else {

            Tile t = getPlayer().getTile();
            str = "You are located " + t.getName() + " . " + t.getDescribe();
        }
        System.out.println(str);
    }

    public String ProcessVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!direct.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n" -> moveN();
                case "s" -> moveS();
                case "e" -> moveE();
                case "w" -> moveW();
                default -> msg = verb + " default msg";
            }
        }
        return msg;
    }


    public String ProcessVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!direct.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        msg += " (not yet implemented)";
        return msg;
    }

    public String ParseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = ProcessVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = ProcessVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public List<String> WordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public void showIntro(){
        String s;
        s = " Testing to see if player is able to move [Enter n, s, w or e]?\n" +
                "(or enter q to quit)";
        System.out.println(s);
    }

    public String RunCommand(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = WordList(lowstr);
                s = ParseCommand(wordlist);
            }
        }
        return s;
    }





    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        Game game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do {
            System.out.print("> ");
            input = in.readLine();
            output = game.RunCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));
    }

}







