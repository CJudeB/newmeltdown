package Movement;
import java.util.ArrayList;

public class Tile {


    private  static String tDescription, tIteractable, tPuzzle;
    private static ArrayList <String> tItems = new ArrayList<>();
    private static boolean tN, tE, tS,tW;

    public Tile(String tDescription, String tInteratable, String tPuzzle, Boolean tN, Boolean tE, Boolean tS, Boolean tW ) {

        this.tDescription = tDescription;
        this.tIteractable = tInteratable;
        this.tPuzzle = tPuzzle;
        this.tN = tN;
        this.tE = tE;
        this.tS = tS;
        this.tW = tW;

    }

    public static Boolean gettN()
    {
        return tN;
    }

    public Boolean gettE()
    {
        return tE;
    }

    public Boolean gettS()
    {
        return tS;
    }

    public Boolean gettW()
    {
        return tW;
    }


    public static String gettDescription() {
        return tDescription;
    }
}
