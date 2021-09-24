package Movement;
import java.util.ArrayList;

public class Tile {


    private String tDescription, tIteractable, tPuzzle;
    private ArrayList <String> tItems = new ArrayList<>();
    private Boolean tN, tE, tS,tW;

    public Tile(String tDescription, String tInteratable, String tPuzzle, Boolean tN, Boolean tE, Boolean tS, Boolean tW ) {

        this.tDescription = tDescription;
        this.tIteractable = tInteratable;
        this.tPuzzle = tPuzzle;
        this.tN = tN;
        this.tE = tE;
        this.tS = tS;
        this.tW = tW;

    }

    public Boolean gettN()
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










}
